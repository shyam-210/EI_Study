package exercise2.command;

import exercise2.singleton.BookingSystem;

public class CancelRoomCommand implements Command {
    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Usage: cancel room <roomId>");
                return;
            }

            int roomId = Integer.parseInt(args[1]);
            BookingSystem.getInstance().cancelBooking(roomId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
