package com.example.demo.repositories;

import com.example.demo.Entities.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BetRepository extends JpaRepository<Bet, UUID> {
}
