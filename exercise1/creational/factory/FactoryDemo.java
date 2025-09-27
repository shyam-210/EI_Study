package exercise1.creational.factory;

import java.util.Scanner;

public class FactoryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("AI Model Factory Demo");
        System.out.println("Commands: gpt <text>, diffusion <prompt>, whisper <audio>, exit");

        String cmd = "";
        while (!"exit".equalsIgnoreCase(cmd)) {
            System.out.print("> ");
            cmd = sc.nextLine().trim();

            if (cmd.equalsIgnoreCase("exit")) break;

            String[] parts = cmd.split(" ", 2);
            if (parts.length < 2) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            try {
                AIModel model = AIModelFactory.getModel(parts[0]);
                model.performTask(parts[1]);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        sc.close();
        System.out.println("Exiting Factory demo.");
    }
}
