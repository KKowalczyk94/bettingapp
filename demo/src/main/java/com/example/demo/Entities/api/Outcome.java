package com.example.demo.Entities.api;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String label;
    private double price;
    private double points;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;
}
