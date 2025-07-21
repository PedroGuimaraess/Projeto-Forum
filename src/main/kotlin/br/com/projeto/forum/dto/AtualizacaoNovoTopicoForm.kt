package br.com.projeto.forum.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

data class AtualizacaoNovoTopicoForm (
    @field:NotNull
    val id: Long,

    @field:NotBlank @field:NotEmpty @field:Size(min = 5, max = 100)
    val titulo: String,

    @field:NotEmpty
    val mensagem: String
)
