package br.com.projeto.forum.service

import br.com.projeto.forum.dto.AtualizacaoNovoTopicoForm
import br.com.projeto.forum.dto.NovoTopicoForm
import br.com.projeto.forum.dto.TopicoViewDto
import br.com.projeto.forum.exception.NotFoundException
import br.com.projeto.forum.mapper.TopicoViewMapper
import br.com.projeto.forum.mapper.TopicoformMapper
import br.com.projeto.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoformMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
) {
    fun listar(): List<TopicoViewDto>{
        return topicos.stream().map {
            t ->  topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long):TopicoViewDto{
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{
            NotFoundException(notFoundMessage)
        }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoViewDto {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() +1
        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoNovoTopicoForm): TopicoViewDto {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().orElseThrow{
            NotFoundException(notFoundMessage)
        }
        val topicoAtualizado = Topico (
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{
            NotFoundException(notFoundMessage)
        }
        topicos = topicos.minus(topico)
    }
}