# Meeting Room Reservation System
5 Baisakh 2083	10 Baisakh 2083
## Problem Statement

Design a meeting room reservation system for a fixed set of conference rooms.

Support:

```java
book(roomId, startTime, endTime)
cancel(bookingId)
isAvailable(roomId, startTime, endTime)
```

Rules:

* No overlapping meetings in the same room.
* Rooms are known beforehand.
* Every booking has a unique booking ID.

---

# Core Classes

## Booking

```java
bookingId
roomId
startTime
endTime
```

Stores reservation details.

## Room

```java
roomId
List<Booking> bookings
```

Responsibilities:

* Check availability
* Add booking
* Delete booking

## MeetingService

```java
Map<String, Room> rooms
Map<String, Booking> bookingMap
```

Responsibilities:

* Manage rooms
* Create bookings
* Generate booking IDs
* Handle cancellations

---

# Data Structures

### Room Lookup

```java
Map<String, Room>
```

Purpose:

```text
O(1) room access
```

### Booking Lookup

```java
Map<String, Booking>
```

Purpose:

```text
O(1) cancellation lookup
```

### Room Bookings

```java
List<Booking>
```

Purpose:

```text
Availability checks
```

---

# Overlap Logic

Two meetings overlap if:

```java
start1 < end2 &&
start2 < end1
```

Examples:

```text
10-12 and 11-13 -> overlap
10-11 and 11-12 -> no overlap
```

---

# Booking Flow

```text
Find room
→ Check availability
→ Generate bookingId
→ Create booking
→ Add to room
→ Add to bookingMap
→ Return booking
```

---

# Cancellation Flow

```text
Find booking from bookingMap
→ Find room
→ Remove from room bookings
→ Remove from bookingMap
```

Since booking exists in two places, remove from both.

---

# Complexity

Let B = bookings in a room.

### Book

```text
Room lookup      O(1)
Availability     O(B)
Insert           O(1)

Total            O(B)
```

### Cancel

```text
Booking lookup   O(1)
Room lookup      O(1)
List remove      O(B)

Total            O(B)
```

---

# Exception Handling

```java
Room not found
Booking not found
startTime >= endTime
```

---

# Follow-Up: Large Number of Bookings

Problem:

```text
List scan becomes expensive.
```

Optimization:

```java
TreeSet<Booking>
```

(sorted by start time)

Benefits:

```text
Search   O(log B)
Insert   O(log B)
Delete   O(log B)
```

Idea:

Check only neighboring bookings instead of scanning all bookings.

---

# Follow-Up: Find Available Rooms

```java
List<Room> getAvailableRooms(start, end)
```

Simple solution:

```java
for(Room room : rooms.values())
{
    if(room.isAvailable(start, end))
        result.add(room);
}
```

Complexity:

```text
O(R × B)
```

R = rooms

B = average bookings per room

---

# Follow-Up: Recurring Meetings

Examples:

```text
Daily Standup
Weekly Sync
Monthly Review
```

Possible additions:

```java
RecurringBooking
RepeatPattern
```

---

# Follow-Up: Concurrent Bookings

Problem:

Two threads may simultaneously book the same room.

Result:

```text
Double booking
```

### Solution 1

```java
synchronized book(...)
synchronized cancel(...)
```

Makes booking atomic.

### Atomicity

```text
Check Availability
+ Create Booking
+ Insert Booking
```

must happen as one unit.

---

# Coarse vs Fine-Grained Locking

### Coarse-Grained

```java
synchronized MeetingService
```

Pros:

```text
Simple
```

Cons:

```text
Blocks all bookings
```

### Fine-Grained

```java
synchronized(room)
```

Pros:

```text
Different rooms can be booked simultaneously
```

---

# ConcurrentHashMap

Replace:

```java
HashMap
```

with:

```java
ConcurrentHashMap
```

Benefits:

```text
Thread-safe map operations
Better concurrency
```

Note:

```text
ConcurrentHashMap alone does NOT prevent double booking.
Synchronization is still required.
```

---

# Visibility

Without synchronization:

```text
One thread may not immediately see updates from another thread.
```

Synchronization provides visibility guarantees.

---

# Concepts Revised

* OOP Design
* Encapsulation
* HashMap
* Interval Overlap Problems
* Service Layer Pattern
* Complexity Analysis
* TreeSet
* Race Conditions
* Atomicity
* Visibility
* Synchronization
* ConcurrentHashMap
* Coarse vs Fine-Grained Locking
