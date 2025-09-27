package exercise1.structural.proxy;

import java.util.Scanner;

public class ProxyDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Proxy Pattern Demo - Enhanced Large Dataset Loader");
        System.out.print("Enter dataset filename: ");
        String file = sc.nextLine().trim();

        Dataset dataset = new ProxyDataset(file);

        System.out.println("Commands: show <role>, exit");
        System.out.println("Example: show admin OR show user");

        String cmd = "";
        while (!"exit".equalsIgnoreCase(cmd)) {
            System.out.print("> ");
            cmd = sc.nextLine().trim().toLowerCase();

            if (cmd.startsWith("show")) {
                String[] parts = cmd.split(" ");
                if (parts.length < 2) {
                    System.out.println("Please provide a role (admin/user).");
                } else {
                    String role = parts[1];
                    dataset.display(role);
                }
            } else if ("exit".equalsIgnoreCase(cmd)) {
                System.out.println("Exiting Proxy demo.");
            } else {
                System.out.println("Unknown command. Use: show <role>, exit");
            }
        }

        sc.close();
    }
}
