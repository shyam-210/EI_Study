package exercise2.utils;

import exercise2.singleton.OfficeConfig;

public class Validator {

    public static void validateRoomNumber(int roomId) {
        if (!OfficeConfig.getInstance().getAllRooms().containsKey(roomId)) {
            throw new IllegalArgumentException("Invalid room number. Please enter a valid room number.");
        }
    }

    public static void validateRoomNumberExist(int roomId) {
        if (!OfficeConfig.getInstance().getAllRooms().containsKey(roomId)) {
            throw new IllegalArgumentException("Room " + roomId + " does not exist.");
        }   
    }

    public static void validateCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity. Please enter a valid positive number.");
        }
    }

    public static void validateOccupants(int roomId, int count) {
        validateRoomNumber(roomId);
        int maxCapacity = OfficeConfig.getInstance().getRoom(roomId).getCapacity();
        if (count < 0 || count > maxCapacity) {
            throw new IllegalArgumentException("Invalid occupant count. Must be between 0 and " + maxCapacity);
        }
    }

    public static void validateDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Invalid duration. Please enter a positive number.");
        }
    }

}
