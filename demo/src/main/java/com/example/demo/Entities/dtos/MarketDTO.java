package com.example.demo.Entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketDTO {
    private String key;
    private String lastUpdate;
    private List<OutcomeDTO> outcomes;
}
