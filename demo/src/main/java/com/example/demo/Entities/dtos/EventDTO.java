package com.example.demo.Entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private UUID id;
    private String sportKey;
    private String sportTitle;
    private String commenceTime;
    private String homeTeam;
    private String awayTeam;
    private List<BookmakerDTO> bookmakers;
}
