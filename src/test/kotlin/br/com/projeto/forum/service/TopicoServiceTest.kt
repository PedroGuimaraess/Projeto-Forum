package br.com.projeto.forum.service

import br.com.projeto.forum.mapper.TopicoViewMapper
import br.com.projeto.forum.mapper.TopicoformMapper
import br.com.projeto.forum.model.TopicoTest
import br.com.projeto.forum.model.TopicoViewTest
import br.com.projeto.forum.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class TopicoServiceTest {
    val topicos = PageImpl(listOf(TopicoTest.build()))

    val paginacao: Pageable = mockk()

    val topicoRepository: TopicoRepository = mockk {
        every { findByCursoNome(any(), any()) } returns topicos
    }

    val topicoViewMapper: TopicoViewMapper = mockk()
    val topicoFormMapper: TopicoformMapper = mockk()

    val topicoService = TopicoService(
        topicoRepository, topicoViewMapper, topicoFormMapper
    )

    @Test
    fun `deve listar topicos a partir do nome do curos`() {
        every { topicoViewMapper.map(any()) } returns (TopicoViewTest.build())

        topicoService.listar("Kotlin anvaçado", paginacao)

        verify(exactly = 1) { topicoRepository.findByCursoNome(any(),any()) }
        verify(exactly = 1) {topicoViewMapper.map(any())}
        verify(exactly = 0) { topicoRepository.findAll(paginacao) }

    }

}