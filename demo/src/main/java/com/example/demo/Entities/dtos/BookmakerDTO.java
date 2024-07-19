package com.example.demo.Entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookmakerDTO {
    private String key;
    private String title;
    private String lastUpdate;
    private List<MarketDTO> markets;
}
