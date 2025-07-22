package br.com.projeto.forum.repository

import br.com.projeto.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}