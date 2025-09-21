package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model;

public class FloorRequest {
    private final int floor;
    private final Direction direction; // caller direction (optional)

    public FloorRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() { return floor; }

    @Override
    public String toString() {
        return "Request body: [floor = " + floor + ", dir = " + direction + "]";
    }
}
