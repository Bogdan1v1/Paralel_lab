package com.example.demo.controllers;

import com.example.demo.dto.ShipmentCreateDTO;
import com.example.demo.models.Shipment;
import com.example.demo.services.ShipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Shipment> getAll() {
        return shipmentService.getAllShipments();
    }
}