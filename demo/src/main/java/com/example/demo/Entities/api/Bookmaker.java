package com.example.demo.Entities.api;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Bookmaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String key;
    private String title;
    private String lastUpdate;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "bookmaker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Market> markets;
}
