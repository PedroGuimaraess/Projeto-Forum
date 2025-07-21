package br.com.projeto.forum.dto

import java.time.LocalDateTime

data class ErrorViewDto(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)