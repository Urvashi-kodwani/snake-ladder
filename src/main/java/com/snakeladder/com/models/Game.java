package com.snakeladder.com.models;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Getter
public class Game {

    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    private Board board;
    private Dice dice;

    public Game(int boardSize) {
        this.players = new ArrayDeque<Player>();
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        board = new Board(boardSize);
        dice = new Dice(1, 6, 1);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addSnakes(Snake snake) {
        snakes.add(snake);
    }

    public void addLadders(Ladder ladder) {
        ladders.add(ladder);
    }

    public void playGame() {
        while (true) {
            Player player = players.poll();
            int diceValue = dice.roll();
            int newPosition = player.getPosition() + diceValue;
            if (newPosition > board.getEnd()) {
                player.setPosition(player.getPosition());
                players.offer(player);
            } else {
                player.setPosition(getNewPosition(newPosition,player.getName()));
                if (player.getPosition() == board.getEnd()) {
                    player.setWon(true);
                    System.out.println("Player " + player.getName() + " won the game");
                    break;
                } else {
                    System.out.println("Setting " + player.getName() + "'s new position to " + player.getPosition());
                    players.offer(player);
                }
            }
        }
    }

    private int getNewPosition(int position,String name) {
        for (Snake snake : snakes) {
            if (snake.getHead() == position) {
                System.out.println("Player "+name+" bit by Snake");
                return snake.getTail();
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.getStart() == position) {
                System.out.println("Player "+name+" Climbed Ladder");
                return ladder.getEnd();
            }
        }
        return position;
    }
}
