package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.controller;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model.Elevator;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.utils.EventLogger;

public class ElevatorController {
    private final Elevator elevator;
    private final Scheduler scheduler;
    private final EventLogger logger;

    public ElevatorController(Elevator elevator, Scheduler scheduler, EventLogger logger) {
        this.elevator = elevator;
        this.scheduler = scheduler;
        this.logger = logger;
    }

    // Run simulation for given number of steps
    public void start(int maxSteps) {
        logger.info("Starting elevator simulation...");
        for (int step = 0; step < maxSteps; step++) {

            // Get next floor from scheduler
            Integer nextStop = scheduler.nextStopForElevator();
            if (nextStop != null) {
                elevator.addStop(nextStop);
            }

            // Move elevator one step
            elevator.step();

            // If elevator has no stops and scheduler is empty -> finish early
            if (nextStop == null && elevator.getDirection().name().equals("IDLE")) {
                logger.info("No more requests. Stopping simulation.");
                break;
            }
        }
        logger.info("Simulation ended.");
    }
}
