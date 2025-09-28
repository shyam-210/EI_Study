package exercise2.singleton;

import exercise2.model.Booking;
import exercise2.model.Room;
import java.time.LocalDateTime;

public class BookingSystem {
    private static BookingSystem instance;

    private BookingSystem() {
    }

    public static synchronized BookingSystem getInstance() {
        if (instance == null) {
            instance = new BookingSystem();
        }
        return instance;
    }

    public void bookRoom(int roomId, LocalDateTime startTime, int durationMinutes) {
        Room room = OfficeConfig.getInstance().getRoom(roomId);
        if (room == null) {
            System.out.println("Room " + roomId + " does not exist.");
            return;
        }

        if (room.getBooking().isPresent() && room.getBooking().get().isActive()) {
            System.out.println("Room " + roomId + " is already booked during this time. Cannot book.");
            return;
        }

        Booking booking = new Booking(roomId, startTime, durationMinutes);
        room.setBooking(booking);
        System.out.println("Room " + roomId + " booked from " + startTime + " for " + durationMinutes + " minutes.");
    }

    public void cancelBooking(int roomId) {
        Room room = OfficeConfig.getInstance().getRoom(roomId);

        if (room.getBooking().isEmpty() || !room.getBooking().get().isActive()) {
            System.out.println("Room " + roomId + " is not booked. Cannot cancel booking.");
            return;
        }

        room.releaseBooking();
        System.out.println("Booking for Room " + roomId + " cancelled successfully.");
    }

    public void releaseIfUnoccupied(int roomId) {
        Room room = OfficeConfig.getInstance().getRoom(roomId);

        if (room.getBooking().isPresent() && !room.isOccupied()) {
            room.releaseBooking();
            System.out.println("Room " + roomId + " is now unoccupied. Booking released. AC and lights off.");
        }
    }
}
