package exercise1.structural.decorator;

import java.util.Scanner;

public class DecoratorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();
        Learner student = new Student(name);

        System.out.println("Decorator Pattern Demo - Online Learning Badges");
        System.out.println("Commands: java, ai, top, show, exit");

        String cmd = "";
        while (!"exit".equalsIgnoreCase(cmd)) {
            System.out.print("> ");
            cmd = sc.nextLine().trim().toLowerCase();

            switch (cmd) {
                case "java":
                    student = new JavaBadge(student);
                    System.out.println("✅ Java Pro Badge added!");
                    break;
                case "ai":
                    student = new AIBadge(student);
                    System.out.println("✅ AI Expert Badge added!");
                    break;
                case "top":
                    student = new TopPerformerBadge(student);
                    System.out.println("✅ Top Performer Badge added!");
                    break;
                case "show":
                    System.out.println(student.getDescription());
                    break;
                case "exit":
                    System.out.println("Exiting Decorator demo.");
                    break;
                default:
                    System.out.println("Unknown command. Use: java, ai, top, show, exit");
            }
        }

        sc.close();
    }
}
