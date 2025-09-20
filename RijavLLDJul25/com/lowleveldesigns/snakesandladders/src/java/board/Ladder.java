package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.board;

public class Ladder extends Jump {
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String type() {
        return "LADDER";
    }
}
