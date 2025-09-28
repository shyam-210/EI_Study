package exercise2.command;

import exercise2.singleton.BookingSystem;
import java.time.LocalDateTime;
import exercise2.utils.Validator;

public class BookRoomCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (args.length != 5) {
            System.out.println("Usage: block room <roomId> <HH:mm> <durationMinutes>");
            return;
        }

        int roomId;
        int duration;

        // Parse room ID
        try {
            roomId = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }

        // Parse duration
        try {
            duration = Integer.parseInt(args[4]);
        } catch (NumberFormatException e) {
            System.out.println("Duration must be an integer.");
            return;
        }

        String time = args[3];
        int hour, minute;

        // Parse time
        String[] hm = time.split(":");
        if (hm.length != 2) {
            System.out.println("Invalid time format. Use HH:mm.");
            return;
        }

        try {
            hour = Integer.parseInt(hm[0]);
            minute = Integer.parseInt(hm[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid time format. Hours and minutes must be integers.");
            return;
        }

        try {
            // Validate room existence and duration
            Validator.validateRoomNumberExist(roomId);
            Validator.validateDuration(duration);

            // Build LocalDateTime
            LocalDateTime startTime = LocalDateTime.now()
                    .withHour(hour)
                    .withMinute(minute)
                    .withSecond(0)
                    .withNano(0);

            // Book the room
            BookingSystem.getInstance().bookRoom(roomId, startTime, duration);

        } catch (IllegalArgumentException iae) {
            System.out.println("Error: " + iae.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
