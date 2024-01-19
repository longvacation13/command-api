package com.api.test.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TestDto {

    @NotBlank(message = "values cannot be empty")
    String values;
}
