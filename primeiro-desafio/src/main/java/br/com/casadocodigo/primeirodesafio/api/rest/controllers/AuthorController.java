package br.com.casadocodigo.primeirodesafio.api.rest.controllers;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import br.com.casadocodigo.primeirodesafio.api.domain.services.impl.AuthorServiceImpl;
import br.com.casadocodigo.primeirodesafio.api.rest.mapper.AuthorMapperRequest;
import br.com.casadocodigo.primeirodesafio.api.rest.mapper.AuthorMapperResponse;
import br.com.casadocodigo.primeirodesafio.api.rest.models.request.AuthorRequestModel;
import br.com.casadocodigo.primeirodesafio.api.rest.models.response.AuthorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "author")
public class AuthorController {

    @Autowired
    private AuthorMapperRequest authorMapperRequest;
    @Autowired
    private AuthorMapperResponse authorMapperResponse;

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

//    @PostMapping
//    public ResponseEntity<AuthorResponseModel> createAuthor(@Valid @RequestBody AuthorRequestModel authorRequestModel) {
//        var author = authorMapperRequest.toAuthorRequest(authorRequestModel);
//        var authorSave = authorService.registerAuthor(author);
//        return new ResponseEntity<>(authorMapperResponse.toAuthorResponse(authorSave)),HttpStatus.OK);
//    }

    @PostMapping
    public AuthorResponseModel createAuthor(@Valid @RequestBody AuthorRequestModel authorRequestModel) {
        var author = authorMapperRequest.toAuthorRequest(authorRequestModel);
        var authorSave = authorService.registerAuthor(author);
        return authorMapperResponse.toAuthorResponse(authorSave);
    }

}
