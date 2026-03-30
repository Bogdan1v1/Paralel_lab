package com.example.demo.repositories;

import com.example.demo.models.Shipment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ShipmentRepository {
    private final List<Shipment> shipments = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Shipment save(Shipment shipment) {
        if (shipment.getId() == null) {
            shipment.setId(idGenerator.getAndIncrement());
        }
        shipments.add(shipment);
        return shipment;
    }

    public List<Shipment> findAll() {
        return new ArrayList<>(shipments); // Повертаємо копію списку
    }

    public Optional<Shipment> findById(Long id) {
        return shipments.stream()
            .filter(s -> s.getId().equals(id))
            .findFirst();
    }
}