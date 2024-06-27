package com.example.demo.Entities;

import jakarta.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Entity
public class Bet {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ActionItem> actionItems;


}
