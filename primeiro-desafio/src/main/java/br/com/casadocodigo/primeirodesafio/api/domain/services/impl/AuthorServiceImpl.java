package br.com.casadocodigo.primeirodesafio.api.domain.services.impl;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import br.com.casadocodigo.primeirodesafio.api.domain.repositories.AuthorRepository;
import br.com.casadocodigo.primeirodesafio.api.domain.services.IAuthorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorServiceImpl implements IAuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public Author registerAuthor(final Author author) {
        final var createAuthor = this.authorRepository.save(author);
        return createAuthor;
    }
}
