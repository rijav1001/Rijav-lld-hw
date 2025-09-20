package designpatterns.RijavLLDJul25.com.lowleveldesigns.snakesandladders.src.java.util;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void info(String msg) {
        System.out.println("UPDATE: " + msg);
    }
}
