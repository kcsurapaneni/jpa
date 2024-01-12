package com.learn.jpa.dto;

import com.learn.jpa.domain.*;

/**
 * @author Krishna Chaitanya
 */
public record CategoryDTO(Integer id, String name) {

    public static CategoryDTO of(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

}
