package com.example.demo.controllers;

import com.example.demo.Entities.Bet;
import com.example.demo.services.BetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("bets")
public class BetController {

    private final BetService betService;

    @PostMapping
    public Bet createBet(@RequestBody Bet bet){
        return betService.createBet(bet);
    }

    @GetMapping
    public List<Bet> getallBets(){
        return  betService.getAllBets();
    }
}
