package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.hardware.Door;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.hardware.Motor;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.utils.EventLogger;

import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;

public class Elevator {
    private final String id;
    private final int minFloor;
    private final int maxFloor;
    private int currentFloor;
    private Direction direction = Direction.IDLE;
    private final Set<Integer> stops = new TreeSet<>();
    private final Motor motor;
    private final Door door;
    private final EventLogger logger;

    public Elevator(String id, int minFloor, int maxFloor, Motor motor, Door door, EventLogger logger) {
        this.id = id;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.currentFloor = minFloor;
        this.motor = motor;
        this.door = door;
        this.logger = logger;
    }

    public Direction getDirection() { return direction; }

    public void addStop(int floor) {
        if (floor < minFloor || floor > maxFloor) {
            logger.warn("Requested floor out of range: " + floor);
            return;
        }
        stops.add(floor);
        logger.info("Added stop " + floor + " stops=" + stops);
        recalcDirectionIfIdle();
    }

    private void recalcDirectionIfIdle() {
        if (direction == Direction.IDLE && !stops.isEmpty()) {
            int next = nearest();
            direction = Direction.fromInt(next - currentFloor);
            logger.info("Direction set to " + direction);
        }
    }

    private int nearest() {
        if (stops.isEmpty()) return currentFloor;
        // prefer stops in current direction if any
        OptionalInt sameDir = direction == Direction.UP
                ? stops.stream().mapToInt(i->i).filter(f->f>currentFloor).findFirst()
                : stops.stream().mapToInt(i->i).filter(f->f<currentFloor).reduce((a,b)->b);
        if (sameDir.isPresent()) return sameDir.getAsInt();
        return stops.iterator().next(); // fallback
    }

    public void step() {
        if (stops.isEmpty()) {
            direction = Direction.IDLE;
            logger.debug("No stops. Elevator idle at " + currentFloor);
            return;
        }

        int target = nearest();
        if (target == currentFloor) {
            // stop & open door
            logger.info(id + " stopping at " + currentFloor);
            door.open();
            // simulate passengers changing target floors: remove this stop
            stops.remove(currentFloor);
            logger.info(id + " passengers boarded at " + currentFloor);
            door.close();
            // recalc direction
            direction = determineDirectionAfterStop();
            return;
        }

        // move one floor towards target
        int diff = target - currentFloor;
        Direction moveDir = Direction.fromInt(diff);
        motor.moveOneFloor(moveDir);
        currentFloor += (moveDir == Direction.UP ? 1 : -1);
        direction = moveDir;
        logger.info(id + " moved to " + currentFloor + " dir = " + direction);
    }

    private Direction determineDirectionAfterStop() {
        if (stops.isEmpty()) return Direction.IDLE;
        int next = nearest();
        return Direction.fromInt(next - currentFloor);
    }
}
