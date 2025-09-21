package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.main.core;

import java.util.Random;

public class FairRoll implements Dice {
    private final Random rnd;
    private final int faces;

    public FairRoll(Random rnd, int faces) {
        this.rnd = rnd;
        this.faces = faces;
    }

    @Override
    public int roll() {
        return rnd.nextInt(faces) + 1;
    }
}
