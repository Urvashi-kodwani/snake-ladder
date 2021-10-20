package com.snakeladder.com;

import com.snakeladder.com.models.Game;
import com.snakeladder.com.models.Ladder;
import com.snakeladder.com.models.Player;
import com.snakeladder.com.models.Snake;

import java.util.Scanner;

public class SnakeLadderApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Board Size");
        int boardSize = scanner.nextInt();
        Game game = new Game(boardSize);
        System.out.println("Enter number of Snakes");
        int snakes = scanner.nextInt();
        while(snakes-->0){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            Snake snake = new Snake(head,tail);
            game.addSnakes(snake);
        }
        System.out.println("Enter number of Ladders");
        int ladders = scanner.nextInt();
        while (ladders-->0){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Ladder ladder = new Ladder(start,end);
            game.addLadders(ladder);
        }
        System.out.println("Enter number of players");
        int players = scanner.nextInt();
        while(players-->0){
            String name = scanner.next();
            Player player = new Player(name);
            game.addPlayer(player);
        }
        game.playGame();
    }
}
