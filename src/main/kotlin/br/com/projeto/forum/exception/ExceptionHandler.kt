package br.com.projeto.forum.exception

import br.com.projeto.forum.dto.ErrorViewDto
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        request: HttpServletRequest,
        exception: NotFoundException
    ): ErrorViewDto {
        return ErrorViewDto(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path =  request.servletPath
        )
    }
}