package com.example.demo.converter;

import com.example.demo.Entities.api.*;
import com.example.demo.Entities.dtos.*;

import java.util.stream.Collectors;

public class EntityToDTOConverter {

    public static SportDTO toSportDTO(Sport sport) {
        return new SportDTO(
                sport.getKey(),
                sport.isActive(),
                sport.getGroup(),
                sport.getDescription(),
                sport.getTitle(),
                sport.isHasOutrights()
        );
    }

    public static EventDTO toEventDTO(Event event) {
        return new EventDTO(
                event.getId(),
                event.getSportKey(),
                event.getSportTitle(),
                event.getCommenceTime(),
                event.getHomeTeam(),
                event.getAwayTeam(),
                event.getBookmakers().stream().map(EntityToDTOConverter::toBookmakerDTO).collect(Collectors.toList())
        );
    }

    public static BookmakerDTO toBookmakerDTO(Bookmaker bookmaker) {
        return new BookmakerDTO(
                bookmaker.getKey(),
                bookmaker.getTitle(),
                bookmaker.getLastUpdate(),
                bookmaker.getMarkets().stream().map(EntityToDTOConverter::toMarketDTO).collect(Collectors.toList())
        );
    }

    public static MarketDTO toMarketDTO(Market market) {
        return new MarketDTO(
                market.getKey(),
                market.getLastUpdate(),
                market.getOutcomes().stream().map(EntityToDTOConverter::toOutcomeDTO).collect(Collectors.toList())
        );
    }

    public static OutcomeDTO toOutcomeDTO(Outcome outcome) {
        return new OutcomeDTO(
                outcome.getName(),
                outcome.getPrice()
        );
    }

    public static EventWithScoresDTO toEventWithScoresDTO(EventWithScores eventWithScores) {
        return new EventWithScoresDTO(
                eventWithScores.getId(),
                eventWithScores.getSportKey(),
                eventWithScores.getSportTitle(),
                eventWithScores.getCommenceTime(),
                eventWithScores.isCompleted(),
                eventWithScores.getHomeTeam(),
                eventWithScores.getAwayTeam(),
                eventWithScores.getScores().stream().map(EntityToDTOConverter::toScoresDTO).collect(Collectors.toList()),
                eventWithScores.getLastUpdate()
        );
    }

    public static ScoresDTO toScoresDTO(Scores scores) {
        return new ScoresDTO(
                scores.getName(),
                scores.getScore()
        );
    }
}
