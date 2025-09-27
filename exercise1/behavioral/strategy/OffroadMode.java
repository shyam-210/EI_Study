package exercise1.behavioral.strategy;

public class OffroadMode implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving in Offroad Mode: High torque, adapted to rough terrain.");
    }
}
