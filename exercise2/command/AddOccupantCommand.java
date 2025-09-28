package exercise2.command;

import exercise2.observer.OccupancySensor;
import exercise2.utils.Validator;

public class AddOccupantCommand implements Command {
    private final OccupancySensor sensor;

    public AddOccupantCommand(OccupancySensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 4) {
                System.out.println("Usage: add occupant <roomId> <count>");
                return;
            }

            int roomId = Integer.parseInt(args[2]);
            int count = Integer.parseInt(args[3]);

            Validator.validateRoomNumberExist(roomId);
            Validator.validateOccupants(roomId, count);

            sensor.updateOccupancy(roomId, count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
