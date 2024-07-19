package com.example.demo.Entities.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Market {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonProperty("key")
    @Column(name = "market_key")
    private String key;

    @ManyToOne
    @JoinColumn(name = "bookmaker_id")
    private Bookmaker bookmaker;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Outcome> outcomes;
}
