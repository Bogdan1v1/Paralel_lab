package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShipmentCreateDTO {
    
    @NotBlank(message = "Опис не може бути порожнім")
    private String description;

    @NotNull(message = "Вага є обов'язковою")
    @Min(value = 1, message = "Вага має бути мінімум 1")
    private Double weight;
}