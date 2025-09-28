package exercise2.model;

import java.util.Optional;

public class Room {
    private int roomId;
    private int capacity;
    private int currentOccupants;
    private boolean occupied;
    private Booking booking;

    public Room(int roomId) {
        this.roomId = roomId;
        this.capacity = 0;
        this.currentOccupants = 0;
        this.occupied = false;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity. Must be positive.");
        }
        this.capacity = capacity;
    }

    public int getCurrentOccupants() {
        return currentOccupants;
    }

    public void updateOccupants(int count) {
        if (count < 0 || count > capacity) {
            throw new IllegalArgumentException("Invalid occupant count.");
        }
        this.currentOccupants = count;
        this.occupied = (count >= 2);
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Optional<Booking> getBooking() {
        return Optional.ofNullable(booking);
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void releaseBooking() {
        if (this.booking != null) {
            this.booking.cancel();
            this.booking = null;
        }
    }

    @Override
    public String toString() {
        return "Room " + roomId +
                " [capacity=" + capacity +
                ", occupants=" + currentOccupants +
                ", occupied=" + occupied +
                ", booked=" + (booking != null && booking.isActive()) +
                "]";
    }
}
