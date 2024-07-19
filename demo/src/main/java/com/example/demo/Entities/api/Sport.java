package com.example.demo.Entities.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
public class Sport {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonProperty("key")
    @Column(name = "sport_key")
    private String key;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("group")
    @Column(name = "sport_group")
    private String group;

    @JsonProperty("description")
    private String description;

    @JsonProperty("title")
    private String title;

    @JsonProperty("has_outrights")
    private boolean hasOutrights;
}
