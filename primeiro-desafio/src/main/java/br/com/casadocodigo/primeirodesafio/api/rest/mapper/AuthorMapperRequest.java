package br.com.casadocodigo.primeirodesafio.api.rest.mapper;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import br.com.casadocodigo.primeirodesafio.api.rest.models.request.AuthorRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapperRequest {

    Author toAuthorRequest(AuthorRequestModel authorRequestModel);
}

