package br.com.projeto.forum.service

import br.com.projeto.forum.exception.NotFoundException
import br.com.projeto.forum.model.Curso
import br.com.projeto.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val cursoRepository: CursoRepository,
    private val notFoundMessage: String = "Id não encontrado!"
) {

    fun buscarPorId(id: Long): Curso {
        return cursoRepository.findById(id).orElseThrow{
            NotFoundException(notFoundMessage)
        }
    }
}
