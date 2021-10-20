package com.snakeladder.com.models;

import lombok.Getter;

@Getter
public class Board {
    private int size;
    private int start;
    private int end;

    Board(int size) {
        this.start = 1;
        this.size = size;
        this.end = start + size - 1;
    }
}
