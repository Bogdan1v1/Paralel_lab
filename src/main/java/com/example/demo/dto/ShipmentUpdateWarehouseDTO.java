package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShipmentUpdateWarehouseDTO {
    @NotNull(message = "ID складу є обов'язковим")
    private Long warehouseId;
}