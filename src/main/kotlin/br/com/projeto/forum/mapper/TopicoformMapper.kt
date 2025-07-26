package br.com.projeto.forum.mapper

import br.com.projeto.forum.dto.NovoTopicoForm
import br.com.projeto.forum.model.Topico
import br.com.projeto.forum.service.CursoService
import br.com.projeto.forum.service.UsuarioServive
import org.springframework.stereotype.Component

@Component
class TopicoformMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioServive,
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return  Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}
