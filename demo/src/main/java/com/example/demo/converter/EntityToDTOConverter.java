package com.example.demo.converter;

import com.example.demo.Entities.api.*;
import com.example.demo.Entities.dtos.*;

import java.util.stream.Collectors;

public class EntityToDTOConverter {

    public static SportDTO toSportDTO(Sport sport) {
        SportDTO sportDTO = new SportDTO();
        sportDTO.setKey(sport.getKey());
        sportDTO.setActive(sport.isActive());
        sportDTO.setGroup(sport.getGroup());
        sportDTO.setDescription(sport.getDescription());
        sportDTO.setTitle(sport.getTitle());
        sportDTO.setHasOutrights(sport.isHasOutrights());
        return sportDTO;
    }

    public static ScoreDTO toScoreDTO(Score score) {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setName(score.getName());
        scoreDTO.setScore(score.getScore());
        scoreDTO.setLastUpdate(score.getLastUpdate());
        return scoreDTO;
    }

    public static EventDTO toEventDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventId(event.getEventId());
        eventDTO.setSportKey(event.getSportKey());
        eventDTO.setSportTitle(event.getSportTitle());
        eventDTO.setCommenceTime(event.getCommenceTime());
        eventDTO.setCompleted(event.isCompleted());
        eventDTO.setHomeTeam(event.getHomeTeam());
        eventDTO.setAwayTeam(event.getAwayTeam());
        eventDTO.setBookmakers(event.getBookmakers().stream().map(EntityToDTOConverter::toBookmakerDTO).collect(Collectors.toList()));
        eventDTO.setScores(event.getScores().stream().map(EntityToDTOConverter::toScoreDTO).collect(Collectors.toList()));
        return eventDTO;
    }

    public static BookmakerDTO toBookmakerDTO(Bookmaker bookmaker) {
        BookmakerDTO bookmakerDTO = new BookmakerDTO();
        bookmakerDTO.setKey(bookmaker.getKey());
        bookmakerDTO.setTitle(bookmaker.getTitle());
        bookmakerDTO.setLastUpdate(bookmaker.getLastUpdate());
        bookmakerDTO.setMarkets(bookmaker.getMarkets().stream().map(EntityToDTOConverter::toMarketDTO).collect(Collectors.toList()));
        return bookmakerDTO;
    }

    public static MarketDTO toMarketDTO(Market market) {
        MarketDTO marketDTO = new MarketDTO();
        marketDTO.setKey(market.getKey());
        marketDTO.setOutcomes(market.getOutcomes().stream().map(EntityToDTOConverter::toOutcomeDTO).collect(Collectors.toList()));
        return marketDTO;
    }

    public static OutcomeDTO toOutcomeDTO(Outcome outcome) {
        OutcomeDTO outcomeDTO = new OutcomeDTO();
        outcomeDTO.setLabel(outcome.getLabel());
        outcomeDTO.setPrice(outcome.getPrice());
        outcomeDTO.setPoints(outcome.getPoints());
        return outcomeDTO;
    }
}
