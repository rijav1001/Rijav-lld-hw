package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.board;

public class Snake extends Jump {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String type() {
        return "SNAKE";
    }
}
