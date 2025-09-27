package exercise1.behavioral.strategy;

public class UrbanMode implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving in Urban Mode: Reduced speed and Enhanced break sensitivity");
    }
}
