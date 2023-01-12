package br.com.casadocodigo.primeirodesafio.api.rest.controllers;

import br.com.casadocodigo.primeirodesafio.api.domain.entities.Category;
import br.com.casadocodigo.primeirodesafio.api.domain.services.impl.CategoryServiceImpl;
import br.com.casadocodigo.primeirodesafio.api.domain.services.impl.ProibeNomeDuplicadoCategoriaValidator;
import br.com.casadocodigo.primeirodesafio.api.rest.mapper.CategoryMapper;
import br.com.casadocodigo.primeirodesafio.api.rest.models.request.CategoryRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryRequestModel categoryRequestModel) {
        Category category = categoryMapper.toEntityCategory(categoryRequestModel);
        return new ResponseEntity<>((categoryService.registerCategory(category)), HttpStatus.OK);
    }

}
