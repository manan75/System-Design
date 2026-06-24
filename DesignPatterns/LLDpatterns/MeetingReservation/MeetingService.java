package DesignPatterns.LLDpatterns.MeetingReservation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MeetingService {

    private Map<String, Room> rooms;
    private Map<String, Booking> bookings;

    public MeetingService() {
        rooms = new HashMap<>();
        bookings = new HashMap<>();
    }
    public void addRoom(String roomId) {
        rooms.put(roomId, new Room(roomId));
    }

    public Booking book(String roomId,int startTime,int endTime) {

        Room curr = rooms.get(roomId);
        if (curr == null) {
            throw new RuntimeException("Room not found");
        }
        if (startTime >= endTime) {
            throw new IllegalArgumentException(
                "Invalid meeting interval"
            );
        }
        if (!curr.isAvailable(startTime, endTime)) {
            throw new RuntimeException(
                "Room not available"
            );
        }
        String bookingId =
            roomId + "_" + UUID.randomUUID();
        Booking b = new Booking(
            roomId,
            bookingId,
            startTime,
            endTime
        );

        curr.addBooking(b);
        bookings.put(bookingId, b);
        return b;
    }

    public void cancel(String bookingId) {
        Booking b = bookings.get(bookingId);
        if (b == null) {
            throw new RuntimeException(
                "Booking not found"
            );
        }
        String roomId = b.getRoomId();
        Room room = rooms.get(roomId);
        room.deleteBooking(b);
        bookings.remove(bookingId);
    }
}