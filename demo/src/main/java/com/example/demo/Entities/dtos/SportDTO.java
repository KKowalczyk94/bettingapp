package com.example.demo.Entities.dtos;

import lombok.Data;

@Data
public class SportDTO {
    private String key;
    private boolean active;
    private String group;
    private String description;
    private String title;
    private boolean hasOutrights;
}
