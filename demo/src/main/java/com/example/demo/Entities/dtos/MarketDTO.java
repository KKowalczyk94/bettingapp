package com.example.demo.Entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class MarketDTO {

    private String key;
    private String lastUpdate;
    private List<OutcomeDTO> outcomes;
}
