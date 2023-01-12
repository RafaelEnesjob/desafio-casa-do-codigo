package br.com.casadocodigo.primeirodesafio.api.domain.repositories;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByName(String name);
}
