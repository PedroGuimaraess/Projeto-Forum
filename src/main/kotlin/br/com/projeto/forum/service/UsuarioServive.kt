package br.com.projeto.forum.service

import br.com.projeto.forum.exception.NotFoundException
import br.com.projeto.forum.model.Usuario
import br.com.projeto.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioServive(
    private val usuarioRepository: UsuarioRepository,
    private val notFoundMessage: String = "Id não encontrado!"
) {
    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id).orElseThrow{
            NotFoundException(notFoundMessage)
        }
    }
}
