package com.learn.jpa.service;

import com.learn.jpa.domain.*;
import com.learn.jpa.dto.*;
import com.learn.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * @author Krishna Chaitanya
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategories(final String name, final Integer id) {
        Category category = new Category();
        category.setName(name);
        category.setId(id);
        Example<Category> example = Example.of(category);
        Sort.TypedSort<Category> sort = Sort.sort(Category.class);
        sort.by(Category::getName);
        return categoryRepository.findAll(example, sort).stream().map(CategoryDTO::of).toList();
    }

}
