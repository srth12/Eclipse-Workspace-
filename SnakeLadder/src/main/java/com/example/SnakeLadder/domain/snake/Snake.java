package com.example.SnakeLadder.domain.snake;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Snake {
    private int head;
    private int tail;

    public int swallow(int position){
        return tail;
    }
}
