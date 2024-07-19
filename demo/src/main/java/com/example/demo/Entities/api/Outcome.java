package com.example.demo.Entities.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
public class Outcome {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonProperty("label")
    private String label;

    @JsonProperty("price")
    private double price;

    @JsonProperty("points")
    private double points;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;
}
