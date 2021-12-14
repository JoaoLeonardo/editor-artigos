package br.edu.utfpr.editorartigos.config;

import br.edu.utfpr.editorartigos.exception.CategoriaJaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdviceHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CategoriaJaExisteException.class)
    public ResponseEntity<ErrorResponse> categoriaJaExiste(CategoriaJaExisteException exception, WebRequest request) {
        var errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>((errorResponse), HttpStatus.BAD_GATEWAY);
    }
}
