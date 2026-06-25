# Leaderboard System

## Problem Statement

Design a leaderboard for an online gaming/coding platform supporting:

* `addScore(playerId, score)` → Add score to a player's existing score.
* `reset(playerId)` → Remove/reset a player.
* `topK(K)` → Return the top K players (or sum of their scores).

---

## Initial Approach

### Data Structures

```java
HashMap<Integer, Integer> playerScores;
```

### Idea

* Store player scores in a HashMap.
* For `topK()`, create a Max Heap from all scores whenever the query arrives.

### Complexity

| Operation | TC           |
| --------- | ------------ |
| addScore  | O(1)         |
| reset     | O(1)         |
| topK      | O(N + KlogN) |

### Drawback

If `topK()` is called frequently, rebuilding the heap every time becomes expensive.

---

## Optimized Design

### Data Structures

```java
HashMap<Integer, Player> players;
TreeSet<Player> leaderboard;
```

### Player Class

```java
class Player {
    int id;
    int score;
}
```

### TreeSet Comparator

```java
(a,b) -> {
    if(a.score != b.score)
        return Integer.compare(b.score, a.score);

    return Integer.compare(a.id, b.id);
}
```

### Why TreeSet?

* Keeps players sorted by score at all times.
* Supports efficient insertion and deletion.
* Top K players can be obtained by simple iteration.

---

## Important Observation

Never modify a Player's score while it is inside the TreeSet.

Incorrect:

```java
player.score += 50;
```

Correct:

```java
leaderboard.remove(player);
player.score += 50;
leaderboard.add(player);
```

Reason: TreeSet ordering becomes invalid if key fields are modified in-place.

---

## Operations

### addScore(id, score)

* New player → Create and insert.
* Existing player → Remove from TreeSet, update score, reinsert.

TC: `O(log N)`

### reset(id)

* Remove from TreeSet.
* Remove from HashMap.

TC: `O(log N)`

### topK(K)

* Iterate first K players from TreeSet.

TC: `O(K)`

---

## Final Complexity

| Operation | TC       |
| --------- | -------- |
| addScore  | O(log N) |
| reset     | O(log N) |
| topK      | O(K)     |

---

## Follow-Ups

### 1. Return Rank of a Player

```java
getRank(playerId)
```

TreeSet cannot provide rank efficiently.

Possible solutions:

* Order Statistic Tree
* Augmented BST

---

### 2. Top K Score Sum in O(log N)

Current approach is O(K).

Possible solution:

* Augmented BST storing subtree sums.

---

### 3. Thread Safety

Multiple users updating leaderboard simultaneously.

Possible solutions:

* synchronized methods
* ReadWriteLock
* ConcurrentSkipListSet

---

## Key LLD Pattern Learned

```java
HashMap + TreeSet
```

Use when:

* Fast lookup is required.
* Data must remain continuously sorted.
* Frequent updates and ordered retrievals are expected.
