package com.example.SnakeLadder.domain.ladder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Ladder {

    private int top;
    private int bottom;

    public int raise(){
        return top;
    }
}
