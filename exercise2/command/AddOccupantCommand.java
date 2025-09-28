package exercise2.command;

import exercise2.observer.OccupancySensor;

public class AddOccupantCommand implements Command {
    private final OccupancySensor sensor;

    public AddOccupantCommand(OccupancySensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 3) {
                System.out.println("Usage: add occupant <roomId> <count>");
                return;
            }

            int roomId = Integer.parseInt(args[1]);
            int count = Integer.parseInt(args[2]);
            sensor.updateOccupancy(roomId, count);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
