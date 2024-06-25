package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class ActionItem {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private double price;
    private int quantity;

}
