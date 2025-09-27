package exercise1.behavioral.observer;

import java.util.logging.Logger;

public class FacultyObserver implements AlertObserver {
    private static final Logger LOGGER = Logger.getLogger(FacultyObserver.class.getName());
    private final String facultyName;

    public FacultyObserver(String name) { this.facultyName = name; }

    @Override
    public void update(Alert alert) {
        LOGGER.info("Faculty: " + facultyName + " received alert: " + alert.getMessage());
        System.out.println("[Faculty " + facultyName + "] " + alert.getType() + " -> " + alert.getMessage());
    }
}
