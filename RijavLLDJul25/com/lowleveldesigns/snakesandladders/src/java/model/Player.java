package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.model;

public class Player {
    private final String id;
    private final String name;
    private int position = 0;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getPosition() { return position; }
    public void setPosition(int pos) { this.position = pos; }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}
