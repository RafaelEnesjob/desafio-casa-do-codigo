package br.com.casadocodigo.primeirodesafio.api.rest.mapper;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import br.com.casadocodigo.primeirodesafio.api.rest.models.response.AuthorResponseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapperResponse {

    AuthorResponseModel toAuthorResponse(Author author);
}

