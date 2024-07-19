package com.example.demo.controllers;


import com.example.demo.Entities.api.Event;
import com.example.demo.Entities.api.Sport;
import com.example.demo.Entities.dtos.EventDTO;
import com.example.demo.Entities.dtos.SportDTO;
import com.example.demo.services.BettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BettingController {


    private final BettingService bettingService;

    @GetMapping("/sports")
    public ResponseEntity<List<SportDTO>> getSports() {
        try {
            List<SportDTO> sports = bettingService.getSports();
            return ResponseEntity.ok(sports);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/odds/{sport}")
    public ResponseEntity<List<EventDTO>> getOdds(@PathVariable String sport) {
        try {
            List<EventDTO> events = bettingService.getOdds(sport);
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/scores/{sport}")
    public ResponseEntity<List<Event>> getScores(@PathVariable String sport) {
        try {
            List<Event> events = bettingService.getScores(sport);
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
