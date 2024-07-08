package com.example.demo.Entities;

import jakarta.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Entity
public class Bet {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ActionItem> actionItems;

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActionItems(List<ActionItem> actionItems) {
        this.actionItems = actionItems;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public List<ActionItem> getActionItems() {
        return actionItems;
    }

    public String getDescription() {
        return description;
    }
}
