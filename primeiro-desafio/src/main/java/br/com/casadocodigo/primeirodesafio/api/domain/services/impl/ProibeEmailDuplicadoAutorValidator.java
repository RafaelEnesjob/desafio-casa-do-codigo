package br.com.casadocodigo.primeirodesafio.api.domain.services.impl;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import br.com.casadocodigo.primeirodesafio.api.domain.exceptions.MethodArgumentNotValidException;
import br.com.casadocodigo.primeirodesafio.api.domain.repositories.AuthorRepository;
import br.com.casadocodigo.primeirodesafio.api.rest.models.request.AuthorRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AuthorRequestModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        AuthorRequestModel authorRequestModel = (AuthorRequestModel) target;
        Optional<Author> possivelAutor = authorRepository.findByEmail(authorRequestModel.getEmail());

        if (possivelAutor.isPresent()) {
            throw new MethodArgumentNotValidException("Já possui um autor com o email informado" + authorRequestModel.getEmail());
        }

    }
}
