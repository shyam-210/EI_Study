package exercise1.behavioral.strategy;

public class SportMode implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving in Sport Mode: High acceleration, performance focused.");
    }
}
        