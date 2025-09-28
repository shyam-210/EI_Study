package exercise2.command;

import exercise2.model.Room;
import exercise2.singleton.OfficeConfig;
import exercise2.utils.Validator;


public class RoomStatusCommand implements Command {
    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 3 || !args[1].equalsIgnoreCase("status")) {
                System.out.println("Usage: room status <roomId>");
                return;
            }

            int roomId = Integer.parseInt(args[2]);
            Validator.validateRoomNumberExist(roomId);
            Room room = OfficeConfig.getInstance().getRoom(roomId);
            System.out.println(room.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
