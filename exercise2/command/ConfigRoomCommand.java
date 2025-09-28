package exercise2.command;

import exercise2.singleton.OfficeConfig;

public class ConfigRoomCommand implements Command {
    @Override
    public void execute(String[] args) {
        try {
            if (args.length == 4 && args[1].equalsIgnoreCase("room") && args[2].equalsIgnoreCase("count")) {
                int count = Integer.parseInt(args[3]);
                OfficeConfig.getInstance().configureRooms(count);
            } else if (args.length == 6 && args[1].equalsIgnoreCase("room") && args[2].equalsIgnoreCase("max") 
                    && args[3].equalsIgnoreCase("capacity")) {
                int roomId = Integer.parseInt(args[4]);
                int capacity = Integer.parseInt(args[5]);
                OfficeConfig.getInstance().getRoom(roomId).setCapacity(capacity);
                System.out.println("Room " + roomId + " maximum capacity set to " + capacity + ".");
            } else {
                System.out.println("Usage: \n" +
                        "config room count <N>\n" +
                        "config room max capacity <roomId> <capacity>");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
