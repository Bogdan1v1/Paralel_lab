package com.example.demo.controllers;

import com.example.demo.dto.ShipmentCreateDTO;
import com.example.demo.dto.ShipmentUpdateWarehouseDTO;
import com.example.demo.models.Shipment;
import com.example.demo.services.ShipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment create(@Valid @RequestBody ShipmentCreateDTO dto) {
        return shipmentService.createShipment(dto);
    }

    // Додали Pageable
    @GetMapping
    public Page<Shipment> getAll(Pageable pageable) {
        return shipmentService.getAllShipments(pageable);
    }

    // PUT запит для зміни складу
    @PutMapping("/{id}")
    public Shipment updateWarehouse(@PathVariable Long id, @Valid @RequestBody ShipmentUpdateWarehouseDTO dto) {
        return shipmentService.updateShipmentWarehouse(id, dto.getWarehouseId());
    }

    // DELETE запит
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
}