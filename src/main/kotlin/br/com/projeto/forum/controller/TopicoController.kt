package br.com.projeto.forum.controller

import br.com.projeto.forum.dto.AtualizacaoNovoTopicoForm
import br.com.projeto.forum.dto.NovoTopicoForm
import br.com.projeto.forum.dto.TopicoViewDto
import br.com.projeto.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoViewDto>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoViewDto{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: NovoTopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoViewDto> {
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoNovoTopicoForm): ResponseEntity<TopicoViewDto> {
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}