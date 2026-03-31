package com.example.demo.services;

import com.example.demo.dto.ShipmentCreateDTO;
import com.example.demo.models.Shipment;
import com.example.demo.models.Warehouse;
import com.example.demo.repositories.ShipmentRepository;
import com.example.demo.repositories.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final WarehouseRepository warehouseRepository; // Додали для пошуку складу

    public Shipment createShipment(ShipmentCreateDTO dto) {
        Shipment shipment = new Shipment();
        shipment.setDescription(dto.getDescription());
        shipment.setWeight(dto.getWeight());
        return shipmentRepository.save(shipment);
    }

    // Пагінація: тепер повертаємо Page замість List
    public Page<Shipment> getAllShipments(Pageable pageable) {
        return shipmentRepository.findAll(pageable);
    }

    // Оновлення складу зберігання
    public Shipment updateShipmentWarehouse(Long shipmentId, Long newWarehouseId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new EntityNotFoundException("Відправлення з ID " + shipmentId + " не знайдено"));

        Warehouse warehouse = warehouseRepository.findById(newWarehouseId)
                .orElseThrow(() -> new EntityNotFoundException("Склад з ID " + newWarehouseId + " не знайдено"));

        shipment.setWarehouse(warehouse);
        return shipmentRepository.save(shipment);
    }

    // Видалення
    public void deleteShipment(Long id) {
        if (!shipmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Відправлення з ID " + id + " не знайдено");
        }
        shipmentRepository.deleteById(id);
    }
}