package br.com.projeto.forum.service

import br.com.projeto.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioServive(
    var usarios: List<Usuario>
) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Pedro",
            email = "pedro@gmail.com"
        )
        usarios = listOf(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usarios.stream().filter { a -> a.id == id }.findFirst().get()
    }
}
