package exercise1.creational.singleton;

import java.util.Scanner;
public class SingletonDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VotingSystem votingSystem = VotingSystem.getInstance();

        System.out.println("Centralized Voting System (Singleton Demo)");
        System.out.println("Commands: vote <candidate>, results, exit");

        String cmd = "";
        while (!"exit".equalsIgnoreCase(cmd)) {
            System.out.print("> ");
            cmd = sc.nextLine().trim();

            if (cmd.startsWith("vote ")) {
                String candidate = cmd.substring(5).trim();
                votingSystem.castVote(candidate);
            } else if (cmd.equalsIgnoreCase("results")) {
                votingSystem.showResults();
            } else if (!cmd.equalsIgnoreCase("exit") && !cmd.isEmpty()) {
                System.out.println("Unknown command. Try again.");
            }
        }

        sc.close();
        System.out.println("Exiting Voting System.");
    }
}
