//package com.example.demo.controllers;
//
//import com.example.demo.Entities.Bet;
//import com.example.demo.services.BetService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("bets")
//public class BetController {
//
//    private final BetService betService;
//
//    public BetController(BetService betService) {
//        this.betService = betService;
//    }
//
//    @PostMapping
//    public Bet createBet(@RequestBody Bet bet){
//        return betService.createBet(bet);
//    }
//
//    @GetMapping
//    public List<Bet> getallBets(){
//        return  betService.getAllBets();
//    }
//}
