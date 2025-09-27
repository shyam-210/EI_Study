package exercise1.behavioral.observer;

import java.util.logging.Logger;

public class StudentObserver implements AlertObserver {
    private static final Logger LOGGER = Logger.getLogger(StudentObserver.class.getName());
    private final String studentName;

    public StudentObserver(String name) { this.studentName = name; }

    @Override
    public void update(Alert alert) {
        LOGGER.info("Student: " + studentName + " received alert: " + alert.getMessage());
        System.out.println("[Student " + studentName + "] " + alert.getType() + " -> " + alert.getMessage());
    }
}
