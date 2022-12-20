package br.com.casadocodigo.primeirodesafio.api.rest.controllers;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import br.com.casadocodigo.primeirodesafio.api.domain.services.impl.AuthorServiceImpl;
import br.com.casadocodigo.primeirodesafio.api.domain.services.impl.ProibeEmailDuplicadoAutorValidator;
import br.com.casadocodigo.primeirodesafio.api.rest.mapper.AuthorMapper;
import br.com.casadocodigo.primeirodesafio.api.rest.models.request.AuthorRequestModel;
import br.com.casadocodigo.primeirodesafio.api.rest.models.response.AuthorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "author")
public class AuthorController {

    @Autowired
    private AuthorMapper converter;

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    public ResponseEntity<AuthorResponseModel> createAuthor(@Valid @RequestBody AuthorRequestModel authorRequestModel) {
        Author author = converter.toEntity(authorRequestModel);
        return new ResponseEntity<>(converter.toModel(authorService.registerAuthor(author)), HttpStatus.CREATED);
    }

}
