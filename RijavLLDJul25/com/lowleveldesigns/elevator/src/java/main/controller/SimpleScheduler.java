package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.controller;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.model.FloorRequest;

import java.util.SortedSet;
import java.util.TreeSet;

public class SimpleScheduler implements Scheduler{
    private final SortedSet<Integer> pending = new TreeSet<>();

    @Override
    public synchronized void submit(FloorRequest req) {
        pending.add(req.getFloor());
    }

    @Override
    public synchronized Integer nextStopForElevator() {
        if (pending.isEmpty()) return null;
        Integer f = pending.first();
        pending.remove(f);
        return f;
    }

}
