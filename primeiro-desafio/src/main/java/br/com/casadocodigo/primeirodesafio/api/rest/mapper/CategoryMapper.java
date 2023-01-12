package br.com.casadocodigo.primeirodesafio.api.rest.mapper;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Category;
import br.com.casadocodigo.primeirodesafio.api.rest.models.request.CategoryRequestModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntityCategory(CategoryRequestModel categoryRequestModel) {
        Category category = new Category();
        category.setName(categoryRequestModel.getName());
        return category;
    }
}
