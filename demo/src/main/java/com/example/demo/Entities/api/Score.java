package com.example.demo.Entities.api;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String score;
    private String lastUpdate;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
