package br.com.casadocodigo.primeirodesafio.api.rest.models.request;

import javax.validation.constraints.NotBlank;

public class CategoryRequestModel {

    @NotBlank
    private String name;

    public CategoryRequestModel(){

    }

    public CategoryRequestModel(@NotBlank String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
