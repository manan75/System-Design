# Train Platform Management System

## Problem Statement

Design a Train Platform Management System for a railway station with a fixed number of platforms.

The system should support:
- Add a train
- Depart a train
- Assign the smallest available platform
- Waitlist trains if all platforms are occupied
- Display current platform occupancy

---

## Approach

### Data Structures

```java
TreeSet<Integer> freePlatforms;
Queue<Train> waitList;
HashMap<Integer, Integer> trainToPlatform;
HashMap<Integer, Train> platformToTrain;
```

- **TreeSet** stores free platform numbers in sorted order, allowing allocation of the smallest available platform.
- **Queue** maintains FIFO order for waiting trains.
- **trainToPlatform** provides O(1) lookup of a train's platform.
- **platformToTrain** helps display current platform occupancy.

### Logic

**Arrival**
- If a platform is free:
  - Allocate the smallest platform.
  - Update both maps.
- Otherwise:
  - Add the train to the waitlist.

**Departure**
- Find the occupied platform.
- Remove the train from both maps.
- If the waitlist is non-empty:
  - Assign the freed platform to the first waiting train.
- Else:
  - Add the platform back to `freePlatforms`.

---

## Key Design Invariant

If the waitlist is non-empty, then no platform is free.

Therefore:
- `addTrain()` never needs to check the waitlist.
- `departTrain()` is solely responsible for assigning waiting trains to newly freed platforms.

---

## Complexity

| Operation | Complexity |
|-----------|------------|
| Add Train | O(log P) |
| Depart Train | O(log P) |
| Waitlist Add/Remove | O(1) |
| Train Lookup | O(1) |

where **P = number of platforms**.

---

# Follow Ups

### 1. Priority Trains
Replace `Queue` with `PriorityQueue` sorted by priority and arrival time.

### 2. Scheduled Arrivals & Departures
Add arrival/departure timestamps and allocate platforms based on schedule using a scheduler/min-heap.

### 3. Platform Types
Add `TrainType` and `PlatformType` and allocate only compatible platforms.

### 4. Platform Maintenance
Introduce platform status (`FREE`, `OCCUPIED`, `MAINTENANCE`) and skip unavailable platforms.

### 5. Multiple Stations
Create a `Station` class where each station owns its own `PlatformManager`.

### 6. Concurrent Requests
Synchronize allocation/deallocation or use `ReentrantLock` and `ConcurrentHashMap`.

### 7. Cancel Waiting Train
Replace the FIFO queue with a removable structure like `LinkedList` or maintain node references.

### 8. Platform Reservation
Reserve specific platforms for particular train types or trains until a given time.

### 9. Train Lookup
Already supported using `trainToPlatform` in O(1).

### 10. Display Free Platforms
Simply iterate over `freePlatforms`.

### 11. Platform History
Maintain `Map<Platform, List<Train>>` to record all trains that used each platform.

### 12. Undo Operations
Maintain a stack of actions to reverse arrivals and departures.

### 13. Analytics
Track usage count, waiting time, occupancy, etc., using counters and timestamps.

### 14. Dynamic Platform Addition
Add/remove platform numbers from `freePlatforms` while ensuring occupied platforms aren't removed.