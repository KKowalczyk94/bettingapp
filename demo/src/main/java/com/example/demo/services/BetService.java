package com.example.demo.services;

import com.example.demo.Entities.Bet;
import com.example.demo.repositories.BetRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {
    private final BetRepository betRepository;


    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public Bet createBet(Bet bet){
        return betRepository.save(bet);
    }

    public List<Bet> getAllBets(){
        return betRepository.findAll();
    }
}
