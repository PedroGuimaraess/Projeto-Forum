package br.com.projeto.forum.dto

import br.com.projeto.forum.model.StatusTopico
import java.time.LocalDateTime

data class UsuarioViewDto (
    val id: Long?,
    var nome: String,
    var email: String,
    val password: String
)
