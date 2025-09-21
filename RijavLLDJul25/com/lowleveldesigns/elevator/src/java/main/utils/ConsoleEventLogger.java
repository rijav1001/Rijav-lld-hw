package designpatterns.RijavLLDJul25.com.lowleveldesigns.elevator.src.java.main.utils;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void info(String msg) {
        System.out.println("UPDATE: " + msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARNING: " + msg);
    }

    @Override
    public void debug(String msg) {
        System.out.println("DEBUG: " + msg);
    }
}
