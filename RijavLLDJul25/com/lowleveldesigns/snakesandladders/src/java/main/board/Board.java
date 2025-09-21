package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.main.board;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {
    private final int size;
    private final Map<Integer, Jump> jumps;

    public Board(int size) {
        this.size = size;
        this.jumps = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void addJump(Jump j) {
        jumps.put(j.getStart(), j);
    }

    public Optional<Jump> jumpAt(int pos) {
        return Optional.ofNullable(jumps.get(pos));
    }
}
