package com.snakeladder.com.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String name;

    @Setter
    boolean won;

    @Setter
    private int position;

    public Player(String name) {
        this.name = name;
        this.won = false;
        this.position = 0;
    }
}
