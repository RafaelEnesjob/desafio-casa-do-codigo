package br.com.casadocodigo.primeirodesafio.api.domain.services.impl;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Category;
import br.com.casadocodigo.primeirodesafio.api.domain.repositories.CategoryRepository;
import br.com.casadocodigo.primeirodesafio.api.domain.services.ICategoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    @Transactional
    public Category registerCategory(final Category category) {
        final var createCategory = this.categoryRepository.save(category);
        return createCategory;
    }
}
