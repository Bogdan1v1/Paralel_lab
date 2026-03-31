package com.example.demo.repositories;

import com.example.demo.models.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    // Тобі не треба писати жодного коду! Spring сам згенерує SQL-запити.
}