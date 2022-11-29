package br.com.casadocodigo.primeirodesafio.api.rest.models.request;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequestModel {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String description;

    public AuthorRequestModel(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(max = 400) String description) {
        super();
        this.name = name;
        this.email = email;
        this.description = description;
    }

//    public Author toModel() {
//        return new Author(this.name, this.email, this.description);
//    }
}
