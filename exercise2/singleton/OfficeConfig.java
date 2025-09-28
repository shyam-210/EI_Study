package exercise2.singleton;

import exercise2.model.Room;
import java.util.HashMap;
import java.util.Map;

public class OfficeConfig {
    private static OfficeConfig instance;
    private final Map<Integer, Room> rooms;

    private OfficeConfig() {
        rooms = new HashMap<>();
    }

    public static synchronized OfficeConfig getInstance() {
        if (instance == null) {
            instance = new OfficeConfig();
        }
        return instance;
    }

    public void configureRooms(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Invalid room count. Must be positive.");
        }
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.put(i, new Room(i));
        }
        System.out.println("Office configured with " + count + " meeting rooms.");
    }

    public Room getRoom(int roomId) {
        if (!rooms.containsKey(roomId)) {
            throw new IllegalArgumentException("Invalid room number. Please enter a valid room number.");
        }
        return rooms.get(roomId);
    }

    public Map<Integer, Room> getAllRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "OfficeConfig{" +
                "rooms=" + rooms +
                '}';
    }
}
