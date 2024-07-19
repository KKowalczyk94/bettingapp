package com.example.demo.Entities.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
public class Score {

    @Id
    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("score")
    private String score;

    @JsonProperty("last_update")
    private String lastUpdate;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
