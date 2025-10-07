package designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.util;

import java.util.*;

public class NotificationService {
    private final List<NotificationObserver> observers = new ArrayList<>();

    public void registerObserver(NotificationObserver obs) {
        observers.add(obs);
    }

    public void notifyAllObservers(String msg) {
        for (NotificationObserver obs: observers) {
            obs.notify(msg);
        }
    }
}
