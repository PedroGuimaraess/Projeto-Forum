package br.com.projeto.forum.mapper

import br.com.projeto.forum.dto.TopicoViewDto
import br.com.projeto.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoViewDto> {

    override fun map(t: Topico): TopicoViewDto {
        return TopicoViewDto(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao
        )
    }
}