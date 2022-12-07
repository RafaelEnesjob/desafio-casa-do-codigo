package br.com.casadocodigo.primeirodesafio.api.domain.entities;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String description;
    private LocalDateTime creationDate = LocalDateTime.now();

    public Author(String name, String email, String description, LocalDateTime creationDate) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.creationDate = creationDate;
    }

    public Author() {
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
