package br.com.projeto.forum.controller

import br.com.projeto.forum.model.Usuario
import br.com.projeto.forum.service.UsuarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario")
class UsuarioController(
    private val service: UsuarioService
) {

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Usuario {
        return service.buscarPorId(id)
    }
}