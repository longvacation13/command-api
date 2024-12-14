package com.main.test.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Getter와 Setter는 spring framework에서 제공하는 Jackson library가 자동으로 json 형식으로 변환해준다.
public class TestDto {

    @NotBlank(message = "values cannot be empty")
    String values;
}
