package br.com.casadocodigo.primeirodesafio.api.rest.models.response;


public class AuthorResponseModel {

    private String name;
    private String email;
    private String description;

    public AuthorResponseModel(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public AuthorResponseModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
