package com.example.demo.Entities.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("sport_key")
    private String sportKey;

    @JsonProperty("sport_title")
    private String sportTitle;

    @JsonProperty("commence_time")
    private String commenceTime;

    @JsonProperty("completed")
    private boolean completed;

    @JsonProperty("home_team")
    private String homeTeam;

    @JsonProperty("away_team")
    private String awayTeam;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bookmaker> bookmakers;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Score> scores;
}
