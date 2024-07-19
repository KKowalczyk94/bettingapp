package com.example.demo.Entities.dtos;

import com.example.demo.Entities.api.Market;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutcomeDTO {
    private String name;
    private double price;
}
