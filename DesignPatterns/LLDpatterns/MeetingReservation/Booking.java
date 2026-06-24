package DesignPatterns.LLDpatterns.MeetingReservation;

public class Booking {

    private String bookingId;
    private String roomId;
    private int startTime;
    private int stopTime;

    public Booking(String roomId, String bookingId, int startTime, int stopTime) {
        this.roomId = roomId;
        this.bookingId = bookingId;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getStopTime() {
        return stopTime;
    }
}