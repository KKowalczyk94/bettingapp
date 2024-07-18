package com.example.demo.Entities.api;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String eventId;
    private String sportKey;
    private String sportTitle;
    private String commenceTime;
    private boolean completed;
    private String homeTeam;
    private String awayTeam;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bookmaker> bookmakers;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Score> scores;
}
