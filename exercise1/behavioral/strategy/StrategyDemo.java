package exercise1.behavioral.strategy;

import java.util.Scanner;

public class StrategyDemo {
    public static void main(String[] args) {
        Vehicle car = new Vehicle(null);
        Scanner sc = new Scanner(System.in);

        System.out.println("Vehicle Strategy Pattern Demo. Type 'help' for commands.");
        String cmd = "";

        while (!"exit".equalsIgnoreCase(cmd)) {
            System.out.print("> ");
            cmd = sc.nextLine().trim().toLowerCase();

            switch (cmd) {
                case "help":
                    System.out.println("Commands: eco, sport, offroad, urban, exit");
                    break;
                case "urban":
                    car.setStrategy(new UrbanMode());
                    car.drive();
                    break;
                case "eco":
                    car.setStrategy(new EcoMode());
                    car.drive();
                    break;
                case "sport":
                    car.setStrategy(new SportMode());
                    car.drive();
                    break;
                case "offroad":
                    car.setStrategy(new OffroadMode());
                    car.drive();
                    break;
                case "exit":
                    System.out.println("Exiting Strategy demo.");
                    break;
                default:
                    System.out.println("Unknown command. Type 'help'.");
            }
        }

        sc.close();
    }
}
