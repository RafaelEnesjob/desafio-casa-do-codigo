package br.com.casadocodigo.primeirodesafio.api.rest.controllers;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import br.com.casadocodigo.primeirodesafio.api.domain.services.impl.AuthorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "author")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
        Author authorSave = authorService.registerAuthor(author);
        return ResponseEntity.ok(authorSave);

    }

}
