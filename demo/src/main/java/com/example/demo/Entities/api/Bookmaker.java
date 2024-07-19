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
public class Bookmaker {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "key")
    @JsonProperty("key")
    private String key;

    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    @Column(name = "last_update")
    @JsonProperty("last_update")
    private String lastUpdate;

    @OneToMany(mappedBy = "bookmaker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("markets")
    private List<Market> markets;
}
