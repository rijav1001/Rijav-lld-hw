package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model;

public enum Direction {
    UP, DOWN, IDLE;

    public static Direction fromInt(int diff) {
        if (diff > 0) return UP;
        if (diff < 0) return DOWN;
        return IDLE;
    }
}
