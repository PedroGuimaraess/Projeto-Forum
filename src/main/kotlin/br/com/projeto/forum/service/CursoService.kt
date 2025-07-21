package br.com.projeto.forum.service

import br.com.projeto.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(
    var cursos: List<Curso>
) {
    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )
        cursos = listOf(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { t -> t.id == id }.findFirst().get()
    }
}
