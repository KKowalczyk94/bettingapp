package com.example.demo.controllers.api;

import com.example.demo.Entities.Bet;

import java.util.List;

public interface BetControllerApi {


     Bet createBet(Bet bet);

     List<Bet> getallBets();
}
