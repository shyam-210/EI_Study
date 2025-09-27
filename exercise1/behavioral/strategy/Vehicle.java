package exercise1.behavioral.strategy;

public class Vehicle {
    private DriveStrategy strategy;

    public Vehicle(DriveStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DriveStrategy strategy) {
        this.strategy = strategy;
    }

    public void drive() {
        if (strategy != null) {
            strategy.drive();
        } else {
            System.out.println("No driving mode selected.");
        }
    }
}
