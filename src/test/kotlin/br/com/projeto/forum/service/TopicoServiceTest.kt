package br.com.projeto.forum.service

import br.com.projeto.forum.mapper.TopicoViewMapper
import br.com.projeto.forum.mapper.TopicoformMapper
import br.com.projeto.forum.model.Topico
import br.com.projeto.forum.model.TopicoTest
import br.com.projeto.forum.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import jakarta.persistence.Entity
import org.springframework.data.domain.PageImpl

class TopicoServiceTest {
    val topicos = PageImpl(listOf(TopicoTest.build()))

    val topicoRepository: TopicoRepository = mockk {
        every { findByCursoNome(any(), any()) } returns topicos
    }

    val topicoViewMapper: TopicoViewMapper = mockk()
    val topicoFormMapper: TopicoformMapper = mockk()

    val topicoService = TopicoService(
        topicoRepository, topicoViewMapper, topicoFormMapper
    )

}