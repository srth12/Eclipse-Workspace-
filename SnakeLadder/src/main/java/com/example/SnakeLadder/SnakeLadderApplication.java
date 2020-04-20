package com.example.SnakeLadder;

import com.example.SnakeLadder.domain.Player;
import com.example.SnakeLadder.domain.board.Board;
import com.example.SnakeLadder.domain.board.ClassicBoard;
import com.example.SnakeLadder.domain.ladder.Ladder;
import com.example.SnakeLadder.domain.snake.Snake;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SnakeLadderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnakeLadderApplication.class, args);
		List<Snake> snakes = Arrays.asList(new Snake(20, 2), new Snake(90, 30));
		List<Ladder> ladders = Arrays.asList(new Ladder(92, 5), new Ladder(60, 6));
		Board board = new ClassicBoard(snakes, ladders);
		Player player1 = new Player("Sarath");
		Player player2 = new Player("Drishya");
		board.addPlayer(player1);
		board.addPlayer(player2);
		board.startPlaying();
	}

}
