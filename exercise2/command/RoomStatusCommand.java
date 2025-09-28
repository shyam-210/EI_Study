package exercise2.command;

import exercise2.model.Room;
import exercise2.singleton.OfficeConfig;

public class RoomStatusCommand implements Command {
    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Usage: room status <roomId>");
                return;
            }

            int roomId = Integer.parseInt(args[1]);
            Room room = OfficeConfig.getInstance().getRoom(roomId);
            System.out.println(room.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
