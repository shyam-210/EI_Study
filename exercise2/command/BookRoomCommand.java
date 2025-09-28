package exercise2.command;

import exercise2.singleton.BookingSystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookRoomCommand implements Command {
    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 4) {
                System.out.println("Usage: block room <roomId> <HH:mm> <durationMinutes>");
                return;
            }

            int roomId = Integer.parseInt(args[1]);
            String time = args[2];
            int duration = Integer.parseInt(args[3]);

            LocalDateTime startTime = LocalDateTime.now().withHour(Integer.parseInt(time.split(":")[0]))
                    .withMinute(Integer.parseInt(time.split(":")[1]))
                    .withSecond(0).withNano(0);

            BookingSystem.getInstance().bookRoom(roomId, startTime, duration);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
