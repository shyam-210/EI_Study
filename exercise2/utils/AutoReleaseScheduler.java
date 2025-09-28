package exercise2.utils;

import exercise2.model.Room;
import exercise2.singleton.BookingSystem;
import exercise2.singleton.OfficeConfig;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class AutoReleaseScheduler {
    private static final long CHECK_INTERVAL_MS = 60 * 1000; // check every 1 minute
    private final Timer timer = new Timer(true);

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkAndReleaseRooms();
            }
        }, 0, CHECK_INTERVAL_MS);
    }

    private void checkAndReleaseRooms() {
        for (Room room : OfficeConfig.getInstance().getAllRooms().values()) {
            room.getBooking().ifPresent(booking -> {
                if (booking.isActive() && !room.isOccupied()) {
                    Duration sinceStart = Duration.between(booking.getStartTime(), LocalDateTime.now());
                    if (sinceStart.toMinutes() >= 5) {
                        BookingSystem.getInstance().releaseIfUnoccupied(room.getRoomId());
                    }
                }
            });
        }
    }
}
