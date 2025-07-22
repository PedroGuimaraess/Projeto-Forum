package br.com.projeto.forum.exception

import br.com.projeto.forum.dto.ErrorViewDto
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
        request: HttpServletRequest,
        exception: Exception
    ): ErrorViewDto {
        return ErrorViewDto(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            path =  request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleServerError(
        request: HttpServletRequest,
        exception: MethodArgumentNotValidException
    ): ErrorViewDto {
        val errorMessage = HashMap<String,String?>()
        exception.bindingResult.fieldErrors.forEach {
            e -> errorMessage.put(e.field, e.defaultMessage) }
        return ErrorViewDto(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path =  request.servletPath
        )
    }
}