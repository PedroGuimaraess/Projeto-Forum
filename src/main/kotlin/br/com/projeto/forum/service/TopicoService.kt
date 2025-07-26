package br.com.projeto.forum.service

import br.com.projeto.forum.dto.AtualizacaoNovoTopicoForm
import br.com.projeto.forum.dto.NovoTopicoForm
import br.com.projeto.forum.dto.TopicoPorCategoriaDto
import br.com.projeto.forum.dto.TopicoViewDto
import br.com.projeto.forum.exception.NotFoundException
import br.com.projeto.forum.mapper.TopicoViewMapper
import br.com.projeto.forum.mapper.TopicoformMapper
import br.com.projeto.forum.repository.TopicoRepository
import jakarta.persistence.EntityManager
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicoRepository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoformMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
) {
    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoViewDto>{
        val topicos = if (nomeCurso == null) {
            topicoRepository.findAll(paginacao)
        } else {
            topicoRepository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map {
            t ->  topicoViewMapper.map(t)
        }
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

    fun relatorio(): List<TopicoPorCategoriaDto> {
        return topicoRepository.relatorio()
    }
}