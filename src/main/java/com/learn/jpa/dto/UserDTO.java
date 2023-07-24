package com.learn.jpa.dto;

import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@Validated
public record UserDTO(
        @Min(1) @Max(Integer.MAX_VALUE) Integer id,
        @NotBlank String name,
        @NotBlank String address
) {
}
