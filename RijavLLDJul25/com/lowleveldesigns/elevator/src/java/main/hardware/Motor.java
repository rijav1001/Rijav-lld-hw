package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.hardware;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model.Direction;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.utils.EventLogger;

public class Motor {
    private final EventLogger logger;
    public Motor(EventLogger logger) { this.logger = logger; }

    // move one floor in direction D
    public void moveOneFloor(Direction d) {
        logger.debug("Motor: moving one floor " + d);
    }
}
