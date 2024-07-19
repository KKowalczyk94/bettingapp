package com.example.demo.Entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportDTO {
    private String key;
    private boolean active;
    private String group;
    private String description;
    private String title;
    private boolean hasOutrights;
}
