package com.example.SnakeLadder.domain.board;

import com.example.SnakeLadder.domain.Player;
import com.example.SnakeLadder.domain.dice.ClassicDice;
import com.example.SnakeLadder.domain.dice.Dice;
import com.example.SnakeLadder.domain.ladder.Ladder;
import com.example.SnakeLadder.domain.snake.Snake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClassicBoard implements Board {

    private List<Player> players;
    private int currentPlayerIndex;
    private Map<Integer, Snake> snakeMap;
    private Map<Integer, Ladder> ladderMap;
    private final int WINNING_POSITION = 100;
    private boolean isGameInProgress = true;

    @Autowired
    private Dice dice;

    public ClassicBoard(List<Snake> snakes, List<Ladder> ladders){
        this.players = new ArrayList<>();
        this.snakeMap = new HashMap<>();
        this.ladderMap = new HashMap<>();
        this.currentPlayerIndex = -1;

        snakes.stream().forEach(snake -> {
            this.snakeMap.put(snake.getHead(), snake);
        });
        ladders.stream().forEach(ladder -> {
            this.ladderMap.put(ladder.getBottom(), ladder);
        });
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public int getNextPlayer(){
        int totalPlayers = players.size();
        return (currentPlayerIndex++ + 1) % totalPlayers;
    }

    private void updatePlayerPosition(int diceNumber, Player player){
        int previousPlayerPositon = player.getCurrentPosition();
        int newPlayerPosition = previousPlayerPositon + diceNumber;
        if (snakeMap.containsKey(newPlayerPosition)){
            Snake snake = snakeMap.get(newPlayerPosition);
            player.setCurrentPosition(snake.getTail());
            System.out.println(player.getName() + "swallowed by snake to " + snake.getTail());
            return;
        }

        if (ladderMap.containsKey(newPlayerPosition)){
            Ladder ladder = ladderMap.get(newPlayerPosition);
            player.setCurrentPosition(ladder.getTop());
            System.out.println(player.getName() + "laddered by ladder to " + ladder.getTop());
            return;
        }

        if (newPlayerPosition == WINNING_POSITION){
            System.out.println("Player " + player.getName() + "Won!!!");
            this.isGameInProgress = false;
            return;
        }

        if (newPlayerPosition > this.WINNING_POSITION){
            System.out.println("No movement for player " + player.getName());
            return;
        }

        player.setCurrentPosition(newPlayerPosition);
        System.out.println(player.getName() + " moved to " + newPlayerPosition);
    }

    public void startPlaying(){
        System.out.println("Game started!!!");
        Dice dice = new ClassicDice();
        while (this.isGameInProgress){
            Player currentPlayer = players.get(getNextPlayer());

            int diceNumber = dice.rollDice();
            System.out.println(currentPlayer.getName() + " rolled " + diceNumber);
            updatePlayerPosition(diceNumber, currentPlayer);
        }
    }
}
