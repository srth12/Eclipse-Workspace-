package com.example.SnakeLadder.domain.board;

import com.example.SnakeLadder.domain.Player;
import com.example.SnakeLadder.domain.dice.Dice;
import org.springframework.stereotype.Service;

@Service
public interface Board {
    public void addPlayer(Player player);
    public void startPlaying();
}
