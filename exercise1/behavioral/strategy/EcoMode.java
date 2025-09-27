package exercise1.behavioral.strategy;

public class EcoMode implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving in Eco Mode: Fuel-efficient, smooth acceleration.");
    }
}
