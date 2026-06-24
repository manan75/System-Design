package DesignPatterns.LLDpatterns.MeetingReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Room {
    private String roomId;
    private List<Booking> bookings;
    public Room(String roomId) {
        this.roomId = roomId;
        this.bookings = new ArrayList<>();
    }
    public boolean isAvailable(int startTime, int stopTime) {
        for (Booking b : bookings) {
            if (b.getStartTime() < stopTime &&
                startTime < b.getStopTime()) {

                return false;
            }
        }
        return true;
    }
   public void addBooking(Booking booking){
    bookings.add(booking);
}
    public void deleteBooking(Booking booking) {
        bookings.remove(booking);
    }
}