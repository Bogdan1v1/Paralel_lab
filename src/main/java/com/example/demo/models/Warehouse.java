package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "warehouses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    // Зв'язок: Один склад має багато відправлень
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<Shipment> shipments;
}