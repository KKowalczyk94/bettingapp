package com.example.demo.Entities.dtos;

import com.example.demo.Entities.api.Score;
import lombok.Data;

import java.util.List;

@Data
public class EventDTO {
    private String eventId;
    private String sportKey;
    private String sportTitle;
    private String commenceTime;
    private boolean completed;
    private String homeTeam;
    private String awayTeam;
    private List<BookmakerDTO> bookmakers;
    private List<ScoreDTO> scores;
}
