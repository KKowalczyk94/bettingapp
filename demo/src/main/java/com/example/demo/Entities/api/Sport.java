package com.example.demo.Entities.api;

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

    @Column(name = "sport_key")
    private String key;
    private boolean active;

    @Column(name = "sport_group")
    private String group;
    private String description;
    private String title;
    private boolean hasOutrights;
}
