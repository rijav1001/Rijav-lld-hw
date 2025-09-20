package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.core;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.board.Board;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.board.Jump;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.model.Player;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.util.EventLogger;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

public class GameEngine {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private final EventLogger logger;

    private final int winningPos;
    private int currentPlayerIndex = 0;
    private boolean finished = false;

    public GameEngine(Board board, List<Player> players, Dice dice, EventLogger logger) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.logger = logger;
        this.winningPos = board.getSize();
    }

    public void start() {
        logger.info("Game started with players: " + playerNames());
        while (!finished) {
            playTurn();
        }
        logger.info("Game finished.");
    }

    private String playerNames() {
        StringJoiner sj = new StringJoiner(", ");
        players.forEach(p -> sj.add(p.toString()));
        return sj.toString();
    }

    private void playTurn() {
        Player p = players.get(currentPlayerIndex);
        int from = p.getPosition();
        int diceVal = dice.roll();

        logger.info(p + " rolled " + diceVal + " from " + from);

        int tentative = from + diceVal;
        if (tentative > winningPos) {
            logger.info(p + " cannot move beyond " + winningPos);
            advancePlayer();
            return;
        }

        int finalPos = tentative;
        Optional<Jump> jump = board.jumpAt(tentative);
        if (jump.isPresent()) {
            Jump j = jump.get();
            finalPos = j.getEnd();
            logger.info(p + " encountered a " + j.type() + " at " + j.getStart() + " -> " + j.getEnd());
        }

        p.setPosition(finalPos);
        logger.info("MOVE: " + p + " now at " + finalPos);

        if (finalPos == winningPos) {
            logger.info("WINNER: " + p);
            finished = true;
            return;
        }

        if (diceVal != 6) {
            advancePlayer();
        } else {
            logger.info(p + " gets an extra turn for rolling 6!");
        }
    }

    private void advancePlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
