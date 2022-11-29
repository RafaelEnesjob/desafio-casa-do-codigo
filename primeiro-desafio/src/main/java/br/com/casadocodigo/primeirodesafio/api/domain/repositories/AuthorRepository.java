package br.com.casadocodigo.primeirodesafio.api.domain.repositories;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
