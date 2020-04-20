package com.example.SnakeLadder.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Player {

    private String name;
    private int currentPosition;

    public Player(String name){
        this.name = name;
    }
}
