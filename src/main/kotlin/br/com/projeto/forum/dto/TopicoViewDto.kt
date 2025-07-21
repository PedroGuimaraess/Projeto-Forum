package br.com.projeto.forum.dto

import br.com.projeto.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoViewDto (
    val id: Long?,
    var titulo: String,
    var mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
