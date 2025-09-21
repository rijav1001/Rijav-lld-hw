package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.hardware;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.utils.EventLogger;

public class Door {
    private final EventLogger logger;
    public Door(EventLogger logger) { this.logger = logger; }

    public void open() {
        logger.info("Door opening");
    }

    public void close() {
        logger.info("Door closing");
    }
}
