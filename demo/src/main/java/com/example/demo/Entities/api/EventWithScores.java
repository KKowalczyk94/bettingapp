package com.example.demo.Entities.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EventWithScores {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @JsonProperty("id")
    @Column(name = "event_id", unique = true)
    private String eventId;

    @JsonProperty("sport_key")
    @Column(name = "sport_key")
    private String sportKey;

    @JsonProperty("sport_title")
    @Column(name = "sport_title")
    private String sportTitle;

    @JsonProperty("commence_time")
    @Column(name = "commence_time")
    private String commenceTime;

    @JsonProperty("completed")
    @Column(name = "completed")
    private boolean completed;

    @JsonProperty("home_team")
    @Column(name = "home_team")
    private String homeTeam;

    @JsonProperty("away_team")
    @Column(name = "away_team")
    private String awayTeam;

    @JsonProperty("last_update")
    @Column(name = "last_update")
    private String lastUpdate;

    @OneToMany(mappedBy = "eventWithScores", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Scores> scores;
}
