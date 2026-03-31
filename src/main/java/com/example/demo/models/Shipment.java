package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Вказує, що це таблиця в БД
@Table(name = "shipments") // Назва таблиці
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматичний інкремент (1, 2, 3...)
    private Long id;

    private String description;
    private Double weight;

    // Зв'язок: Багато відправлень можуть бути на одному складі
    @ManyToOne
    @JoinColumn(name = "warehouse_id") // Назва колонки для зовнішнього ключа
    private Warehouse warehouse;
}