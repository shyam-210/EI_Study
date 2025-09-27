package exercise1.behavioral.observer;

import java.util.*;
import java.util.logging.Logger;

public class AlertSystem {
    private static final Logger LOGGER = Logger.getLogger(AlertSystem.class.getName());
    private final List<AlertObserver> observers = new ArrayList<>();

    public synchronized void register(AlertObserver o) {
        observers.add(o);
        LOGGER.info("Observer registered: " + o.getClass().getSimpleName());
    }

    public synchronized void unregister(AlertObserver o) {
        observers.remove(o);
        LOGGER.info("Observer unregistered: " + o.getClass().getSimpleName());
    }

    public synchronized void notifyAllObservers(Alert alert) {
        LOGGER.info("Notifying observers about: " + alert.getType() + " - " + alert.getMessage());
        for (AlertObserver o : new ArrayList<>(observers)) {
            try {
                o.update(alert);
            } catch (Exception ex) {
                LOGGER.severe("Observer failed: " + ex.getMessage());
            }
        }
    }
}
