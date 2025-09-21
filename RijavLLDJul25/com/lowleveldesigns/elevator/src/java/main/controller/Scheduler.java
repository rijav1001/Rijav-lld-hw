package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.controller;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model.FloorRequest;

public interface Scheduler {
    void submit(FloorRequest req);
    Integer nextStopForElevator();
}
