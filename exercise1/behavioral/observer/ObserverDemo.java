package exercise1.behavioral.observer;

import java.util.Scanner;
import java.util.logging.Logger;

public class ObserverDemo {
    private static final Logger LOGGER = Logger.getLogger(ObserverDemo.class.getName());

    public static void main(String[] args) {
        AlertSystem alertSystem = new AlertSystem();
        Scanner sc = new Scanner(System.in);

        System.out.println("University Alert System Demo. Type 'help' for commands.");
        String cmd = "";

        while (!"exit".equalsIgnoreCase(cmd)) {
            System.out.print("> ");
            cmd = sc.nextLine().trim();

            try {
                if (cmd.equalsIgnoreCase("help")) {
                    System.out.println("Commands:");
                    System.out.println("  register-student <name>");
                    System.out.println("  register-faculty <name>");
                    System.out.println("  register-admin <name>");
                    System.out.println("  types(see all available alert types)");
                    System.out.println("  send <TYPE> <message>");
                    System.out.println("  exit");
                } else if (cmd.startsWith("register-student ")) {
                    String name = cmd.substring("register-student ".length()).trim();
                    alertSystem.register(new StudentObserver(name));
                } else if (cmd.startsWith("register-faculty ")) {
                    String name = cmd.substring("register-faculty ".length()).trim();
                    alertSystem.register(new FacultyObserver(name));
                } else if (cmd.startsWith("register-admin ")) {
                    String name = cmd.substring("register-admin ".length()).trim();
                    alertSystem.register(new AdminObserver(name));
                } else if (cmd.equalsIgnoreCase("types")) {
                    System.out.println("Available Alert Types:");
                    for (Alert.Type t : Alert.Type.values()) {
                        System.out.println("  " + t.name());
                    }
                } else if (cmd.startsWith("send ")) {
                    String[] parts = cmd.substring(5).split(" ", 2);
                    Alert.Type type = Alert.Type.valueOf(parts[0].toUpperCase());
                    String msg = parts.length > 1 ? parts[1] : "";
                    alertSystem.notifyAllObservers(new Alert(type, msg));
                } else if (!cmd.isEmpty() && !"exit".equalsIgnoreCase(cmd)) {
                    System.out.println("Unknown command. Type 'help'.");
                }
            } catch (Exception ex) {
                LOGGER.severe("Error: " + ex.getMessage());
                System.out.println("Invalid input or error: " + ex.getMessage());
            }
        }

        sc.close();
        System.out.println("Exiting Observer demo.");
    }
}
