package br.com.casadocodigo.primeirodesafio.api.domain.services.impl;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Category;
import br.com.casadocodigo.primeirodesafio.api.domain.exceptions.MethodArgumentNotValidException;
import br.com.casadocodigo.primeirodesafio.api.domain.repositories.CategoryRepository;
import br.com.casadocodigo.primeirodesafio.api.rest.models.request.CategoryRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoryRequestModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        CategoryRequestModel categoryRequestModel = (CategoryRequestModel) target;
        Optional<Category> possivelNome = categoryRepository.findByName(categoryRequestModel.getName());

        if (possivelNome.isPresent()) {
            throw new MethodArgumentNotValidException("Já possui uma categoria com esse nome cadastrado" + categoryRequestModel.getName());
        }

    }
}
