package com.ft.trox.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductDto (
    @NotBlank
    @Size(max = 70)
    String title,

    @NotBlank
    @Size(max = 500)
    String description,

    @NotBlank
    @Size(max = 30)
    String category,

    @NotNull
    @Positive
    BigDecimal price,

    @NotBlank
    String user){
}
