package exercise1.behavioral.observer;

import java.util.logging.Logger;

public class AdminObserver implements AlertObserver {
    private static final Logger LOGGER = Logger.getLogger(AdminObserver.class.getName());
    private final String adminName;

    public AdminObserver(String name) { this.adminName = name; }

    @Override
    public void update(Alert alert) {
        LOGGER.info("Admin: " + adminName + " received alert: " + alert.getMessage());
        System.out.println("[Admin " + adminName + "] " + alert.getType() + " -> " + alert.getMessage());
    }
}
