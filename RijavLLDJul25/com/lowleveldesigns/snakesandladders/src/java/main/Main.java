package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.main;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.main.board.*;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.main.core.*;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.main.model.Player;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.main.util.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EventLogger logger = new ConsoleEventLogger();
        Dice dice = new FairRoll(new Random(), 6);

        Board board = new Board(100);
        board.addJump(new Ladder(2, 38));
        board.addJump(new Ladder(7, 14));
        board.addJump(new Snake(16, 6));
        board.addJump(new Snake(49, 11));
        board.addJump(new Ladder(28, 84));
        board.addJump(new Snake(95, 56));

        List<Player> players = Arrays.asList(
                new Player("p1", "Alice"),
                new Player("p2", "Bob")
        );

        GameEngine engine = new GameEngine(board, players, dice, logger);
        engine.start();
    }
}
