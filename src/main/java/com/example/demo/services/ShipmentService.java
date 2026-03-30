package com.example.demo.services;

import com.example.demo.dto.ShipmentCreateDTO;
import com.example.demo.models.Shipment;
import com.example.demo.repositories.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    
    private final ShipmentRepository shipmentRepository;

    public Shipment createShipment(ShipmentCreateDTO dto) {
        Shipment shipment = new Shipment();
        shipment.setDescription(dto.getDescription());
        shipment.setWeight(dto.getWeight());
        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }
}