package exercise2;

import exercise2.command.*;
import exercise2.observer.ACController;
import exercise2.observer.LightController;
import exercise2.observer.OccupancySensor;
import exercise2.utils.AutoReleaseScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmartOfficeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize Observer System
        OccupancySensor sensor = new OccupancySensor();
        sensor.registerObserver(new LightController());
        sensor.registerObserver(new ACController());

        // Initialize Auto Release Scheduler
        AutoReleaseScheduler scheduler = new AutoReleaseScheduler();
        scheduler.start();

        // Command Registry
        Map<String, Command> commands = new HashMap<>();
        commands.put("config", new ConfigRoomCommand());
        commands.put("block", new BookRoomCommand());
        commands.put("cancel", new CancelRoomCommand());
        commands.put("add", new AddOccupantCommand(sensor));
        commands.put("room", new RoomStatusCommand());

        System.out.println("Smart Office Facility Demo. Type 'help' for commands.");

        String input = "";
        while (!"exit".equalsIgnoreCase(input)) {
            System.out.print("> ");
            input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("help")) {
                System.out.println("Available Commands:");
                System.out.println("  config room count <N>");
                System.out.println("  config room max capacity <roomId> <capacity>");
                System.out.println("  block <roomId> <HH:mm> <durationMinutes>");
                System.out.println("  cancel <roomId>");
                System.out.println("  add occupant <roomId> <count>");
                System.out.println("  room status <roomId>");
                System.out.println("  exit");
            } else if (!input.isEmpty() && !"exit".equalsIgnoreCase(input)) {
                String[] parts = input.split(" ");
                String key = parts[0].toLowerCase();

                Command cmd = commands.get(key);
                if (cmd != null) {
                    cmd.execute(parts);
                } else {
                    System.out.println("Unknown command. Type 'help'.");
                }
            }
        }

        sc.close();
        System.out.println("Exiting Smart Office Demo.");
    }
}
