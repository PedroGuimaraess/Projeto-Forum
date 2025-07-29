package br.com.projeto.forum.service

import br.com.projeto.forum.exception.NotFoundException
import br.com.projeto.forum.model.Usuario
import br.com.projeto.forum.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository,
    private val notFoundMessage: String = "Id não encontrado!"
): UserDetailsService {
    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id).orElseThrow{
            NotFoundException(notFoundMessage)
        }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = usuarioRepository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(usuario)
    }
}
