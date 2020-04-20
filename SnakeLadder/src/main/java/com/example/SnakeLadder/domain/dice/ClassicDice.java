package com.example.SnakeLadder.domain.dice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Getter @AllArgsConstructor @Setter
@SuperBuilder
@Component
public class ClassicDice implements Dice {

    @Override
    public int rollDice() {
        return (int) (Math.random() * 6 + 1);
    }
}
