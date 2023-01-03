package br.com.casadocodigo.primeirodesafio.api.domain.exceptions.handler;

import br.com.casadocodigo.primeirodesafio.api.domain.exceptions.MethodArgumentNotValidDetails;
import br.com.casadocodigo.primeirodesafio.api.domain.exceptions.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final String MESSAGE_ERROR = "Já existe um autor cadastrado com o email informado";
    private static final String DETAIL_ERROR = "Informe um email diferente para prosseguir com o cadastro";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        MethodArgumentNotValidDetails methodArgumentNotValidDetails = MethodArgumentNotValidDetails.Builder
                .newBuilder()
                .messageError(MESSAGE_ERROR)
                .Status(HttpStatus.FORBIDDEN.value())
                .detailError(DETAIL_ERROR)
                .build();

        return new ResponseEntity<>(methodArgumentNotValidDetails, HttpStatus.FORBIDDEN);

    }
}
