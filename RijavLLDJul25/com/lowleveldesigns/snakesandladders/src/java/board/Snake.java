package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.board;

public class Snake extends Jump {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String type() {
        return "SNAKE";
    }
}
