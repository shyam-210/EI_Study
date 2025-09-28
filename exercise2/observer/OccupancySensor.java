package exercise2.observer;

import exercise2.model.Room;
import exercise2.singleton.OfficeConfig;
import java.util.ArrayList;
import java.util.List;

public class OccupancySensor {
    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void updateOccupancy(int roomId, int count) {
        Room room = OfficeConfig.getInstance().getRoom(roomId);

        try {
            room.updateOccupants(count);
            boolean occupied = room.isOccupied();

            // Notify all observers
            for (Observer obs : observers) {
                obs.update(occupied, roomId);
            }

            if (occupied) {
                System.out.println("Room " + roomId + " is now occupied by " + count + " persons.");
            } else if (count == 0) {
                System.out.println("Room " + roomId + " is now unoccupied.");
            } else {
                System.out.println("Room " + roomId + " occupancy insufficient to mark as occupied.");
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
