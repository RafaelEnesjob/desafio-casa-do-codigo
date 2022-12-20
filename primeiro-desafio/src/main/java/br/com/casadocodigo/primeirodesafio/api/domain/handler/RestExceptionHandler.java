package br.com.casadocodigo.primeirodesafio.api.domain.handler;

import br.com.casadocodigo.primeirodesafio.api.domain.exceptions.MethodArgumentNotValidDetails;
import br.com.casadocodigo.primeirodesafio.api.domain.exceptions.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        MethodArgumentNotValidDetails methodArgumentNotValidDetails = MethodArgumentNotValidDetails.Builder
                .newBuilder()
                .messageError("Já existe um autor cadastrado com o email informado")
                .Status(HttpStatus.FORBIDDEN.value())
                .detailError("Informe um email diferente para prosseguir com o cadastro")
                .build();

        return new ResponseEntity<>(methodArgumentNotValidDetails, HttpStatus.FORBIDDEN);

    }
}
