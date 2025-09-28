package exercise2.model;

import java.time.LocalDateTime;

public class Booking {
    private int roomId;
    private LocalDateTime startTime;
    private int durationMinutes;
    private boolean active;

    public Booking(int roomId, LocalDateTime startTime, int durationMinutes) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.active = true;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {
        this.active = false;
    }

    public LocalDateTime getEndTime() {
        return startTime.plusMinutes(durationMinutes);
    }

    @Override
    public String toString() {
        return "Booking for Room " + roomId + " from " + startTime + " for " + durationMinutes + " minutes";
    }
}
