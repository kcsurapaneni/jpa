package com.learn.jpa.controller;

import com.learn.jpa.dto.*;
import com.learn.jpa.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "id", required = false) Integer id) {
        return new ResponseEntity<>(categoryService.getCategories(name, id), HttpStatus.OK);
    }

}
