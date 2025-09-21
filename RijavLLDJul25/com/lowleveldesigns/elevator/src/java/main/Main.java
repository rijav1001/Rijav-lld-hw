package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.controller.ElevatorController;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.controller.Scheduler;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.controller.SimpleScheduler;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.hardware.Door;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.hardware.Motor;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model.Direction;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model.Elevator;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model.FloorRequest;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.utils.ConsoleEventLogger;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.utils.EventLogger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EventLogger logger = new ConsoleEventLogger();

        // build elevator
        Motor motor = new Motor(logger);
        Door door = new Door(logger);
        Elevator elevator = new Elevator("Elevator01", 1, 10, motor, door, logger);

        // scheduler & controller
        Scheduler scheduler = new SimpleScheduler();
        ElevatorController controller = new ElevatorController(elevator, scheduler, logger);

        // request gathering
        scheduler.submit(new FloorRequest(3, Direction.UP));
        scheduler.submit(new FloorRequest(7, Direction.DOWN));
        scheduler.submit(new FloorRequest(5, Direction.UP));
        scheduler.submit(new FloorRequest(10, Direction.DOWN));
        scheduler.submit(new FloorRequest(1, Direction.UP));

        // start simulation (blocks)
        controller.start(100);  // max 100 ticks
    }
}
