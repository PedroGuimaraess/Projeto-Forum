package br.com.projeto.forum.service

import br.com.projeto.forum.dto.AtualizacaoNovoTopicoForm
import br.com.projeto.forum.dto.NovoTopicoForm
import br.com.projeto.forum.dto.TopicoViewDto
import br.com.projeto.forum.exception.NotFoundException
import br.com.projeto.forum.mapper.TopicoViewMapper
import br.com.projeto.forum.mapper.TopicoformMapper
import br.com.projeto.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val topicoRepository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoformMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
) {
    fun listar(): List<TopicoViewDto>{
        return topicoRepository.findAll().stream().map {
            t ->  topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long):TopicoViewDto{
        val topico = topicoRepository.findById(id).orElseThrow {
            NotFoundException(notFoundMessage)
        }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoViewDto {
        val topico = topicoFormMapper.map(form)
        topicoRepository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoNovoTopicoForm): TopicoViewDto {
        val topico = topicoRepository.findById(form.id).orElseThrow{
            NotFoundException(notFoundMessage)
        }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicoRepository.deleteById(id)
    }
}