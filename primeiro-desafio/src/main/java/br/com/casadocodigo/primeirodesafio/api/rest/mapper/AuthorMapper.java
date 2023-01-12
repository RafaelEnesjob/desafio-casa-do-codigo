package br.com.casadocodigo.primeirodesafio.api.rest.mapper;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import br.com.casadocodigo.primeirodesafio.api.rest.models.request.AuthorRequestModel;
import br.com.casadocodigo.primeirodesafio.api.rest.models.response.AuthorResponseModel;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toEntityAuthor(AuthorRequestModel authorRequestModel) {
        Author author = new Author();
        author.setName(authorRequestModel.getName());
        author.setEmail(authorRequestModel.getEmail());
        author.setDescription(authorRequestModel.getDescription());
        return author;
    }

    public AuthorResponseModel toModelAuthor(Author author) {
        AuthorResponseModel authorResponseModel = new AuthorResponseModel();
        authorResponseModel.setName(author.getName());
        authorResponseModel.setEmail(author.getEmail());
        authorResponseModel.setDescription(author.getDescription());
        return authorResponseModel;
    }
}
