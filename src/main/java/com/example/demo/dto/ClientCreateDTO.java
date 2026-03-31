package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClientCreateDTO {
    
    @NotBlank(message = "Ім'я не може бути порожнім")
    private String firstName;

    @NotBlank(message = "Прізвище не може бути порожнім")
    private String lastName;

    @NotBlank(message = "Телефон є обов'язковим")
    private String phone;
}