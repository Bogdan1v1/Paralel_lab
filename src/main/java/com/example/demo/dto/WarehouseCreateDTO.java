package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WarehouseCreateDTO {
    
    @NotBlank(message = "Назва складу не може бути порожньою")
    private String name;

    @NotBlank(message = "Адреса є обов'язковою")
    private String address;
}