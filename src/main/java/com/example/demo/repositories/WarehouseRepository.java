package com.example.demo.repositories;

import com.example.demo.models.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class WarehouseRepository {
    private final List<Warehouse> warehouses = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Warehouse save(Warehouse warehouse) {
        if (warehouse.getId() == null) {
            warehouse.setId(idGenerator.getAndIncrement());
        }
        warehouses.add(warehouse);
        return warehouse;
    }

    public List<Warehouse> findAll() {
        return new ArrayList<>(warehouses);
    }

    public Optional<Warehouse> findById(Long id) {
        return warehouses.stream()
            .filter(w -> w.getId().equals(id))
            .findFirst();
    }
}