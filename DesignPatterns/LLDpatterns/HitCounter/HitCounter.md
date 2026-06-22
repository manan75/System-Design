# Design Hit Counter - Complete Revision Notes

## Problem Statement

Design a hit counter for a website.

Support:

```java
recordHit(String page)
getHits(String page)
```

Example:

```java
recordHit("/home");
recordHit("/home");
recordHit("/about");

getHits("/home");  // 2
getHits("/about"); // 1
getHits("/xyz");   // 0
```

Requirements:

* Multiple pages
* Fast hit recording
* Fast retrieval
* Initially single-threaded

---

# Version 1 - Basic Single Threaded

## Data Structure

```java
Map<String,Integer> pageHits
```

Example:

```
/home -> 10
/about -> 5
/contact -> 7
```

## APIs

```java
recordHit(String page)
getHits(String page)
```

## Implementation

```java
recordHit(page)
{
    pageHits.put(
        page,
        pageHits.getOrDefault(page,0)+1
    );
}
```

```java
getHits(page)
{
    return pageHits.getOrDefault(page,0);
}
```

## Complexity

| Operation | Complexity         |
| --------- | ------------------ |
| recordHit | O(1)               |
| getHits   | O(1)               |
| Space     | O(number_of_pages) |

---

# Follow-up 1: Top K Most Visited Pages

## New API

```java
getTopK(int k)
```

Example:

```
/home    100
/about    50
/contact  70
```

Top 2:

```
/home
/contact
```

---

## Approach 1: Max Heap

Create heap during query.

```java
PriorityQueue<Entry<String,Integer>>
```

Max Heap:

```java
(a,b) -> b.getValue()-a.getValue()
```

### Complexity

Build Heap:

```
O(N log N)
```

Extract K:

```
O(K log N)
```

Total:

```
O(N log N)
```

---

## Optimized Approach: Min Heap of Size K

Store only the best K elements.

Comparator:

```java
(a,b) -> a.getValue()-b.getValue()
```

Process:

```java
offer();

if(size > k)
    poll();
```

### Why Min Heap?

Root stores:

```
Worst element among current Top K
```

Whenever a better element arrives:

```
Remove smallest
Insert new element
```

### Complexity

```
O(N log K)
```

Useful when:

```
N >> K
```

Example:

```
N = 1,000,000
K = 10
```

---

## Tradeoff Discussion

### Option A

Store only:

```java
Map<String,Integer>
```

Build heap when queried.

#### Pros

* recordHit O(1)
* Simple implementation

#### Cons

* TopK expensive

---

### Option B

Maintain heap continuously.

#### Pros

* Fast TopK queries

#### Cons

* Every hit updates heap
* More complex

Use when:

```
TopK queries are frequent
```

---

# Follow-up 2: Hits in Last 5 Minutes

## New API

```java
getHits(page,last5Minutes)
```

or

```java
getHits(page,300)
```

---

## Problem

This is not enough:

```java
Map<String,Integer>
```

Need timestamps.

---

## Data Structure

```java
Map<String,Deque<Integer>>
```

Example:

```
/home

[
100,
105,
110,
250,
300
]
```

---

## Record Hit

```java
dq.addLast(timestamp);
```

---

## Query

Remove expired timestamps.

```java
while(
 !dq.isEmpty()
 &&
 dq.peekFirst() < currentTime-300
)
{
    dq.pollFirst();
}
```

Return:

```java
dq.size();
```

---

## Why Deque?

```
Front = Oldest
Back  = Newest
```

Easy removal of old hits.

---

## Complexity

| Operation | Complexity     |
| --------- | -------------- |
| recordHit | O(1)           |
| getHits   | O(1) amortized |

Reason:

```
Each timestamp is inserted once and removed once.
```

---

# Memory Optimization

Problem:

```
1 million hits/minute
```

Deque becomes huge.

---

## Better

Store:

```
timestamp -> count
```

instead of every hit.

Example:

```
1000 -> 50
1001 -> 70
1002 -> 20
```

---

## Best

Fixed size circular array.

```java
int timestamps[300];
int counts[300];
```

Memory:

```
O(300)
```

Regardless of hit volume.

---

# Follow-up 3: Total Website Hits

## API

```java
getTotalHits()
```

---

## Naive

Iterate entire map.

```
O(N)
```

---

## Better

Maintain:

```java
int totalHits;
```

Update during:

```java
recordHit();
```

---

## Complexity

| Operation    | Complexity |
| ------------ | ---------- |
| recordHit    | O(1)       |
| getTotalHits | O(1)       |

---

# Follow-up 4: Most Visited Page

## API

```java
getMostVisitedPage()
```

---

## Naive

Scan map.

```
O(N)
```

---

## Better

Maintain:

```java
String mostVisitedPage;
int maxCount;
```

Update during hit.

---

## Complexity

| Operation          | Complexity |
| ------------------ | ---------- |
| recordHit          | O(1)       |
| getMostVisitedPage | O(1)       |

---

# Follow-up 5: Delete Page

## API

```java
deletePage(page)
```

Need to update:

* pageHits
* totalHits
* mostVisitedPage
* TopK structures

Shows downside of maintaining cached metadata.

---

# Multi-threaded Version

## Problem 1: Race Condition

Current Code

```java
int count = pageHits.getOrDefault(page,0);
pageHits.put(page,count+1);
```

---

## Scenario

Initial:

```
/home = 5
```

Thread A:

```
reads 5
```

Thread B:

```
reads 5
writes 6
```

Thread A:

```
writes 6
```

Final:

```
6
```

Expected:

```
7
```

---

## Lost Update Problem

Multiple threads overwrite each other's updates.

---

# Atomicity

Atomic means:

```
Cannot be interrupted
```

Current increment:

```
Read
Modify
Write
```

Three separate operations.

Not atomic.

---

# Fix 1: Synchronized

```java
public synchronized void recordHit(...)
```

or

```java
synchronized(this)
{
}
```

---

## Drawback

Correct but poor scalability.

---

# Coarse-Grained Locking

Whole object locked.

Example:

```
Thread A -> /home
Thread B -> /about
```

Still blocked.

Only one thread enters at a time.

---

# Visibility Problem

Suppose:

Thread A:

```java
count = 6;
```

Thread B:

```java
read count;
```

Without synchronization:

```
May still see 5
```

because updates may not be visible across threads.

---

# Fix

Use proper synchronization strategy.

Examples:

```java
synchronized
ReadWriteLock
ConcurrentHashMap
AtomicInteger
LongAdder
```

---

# Fine-Grained Locking

Instead of locking entire HitCounter:

Lock per page.

Example:

```
/home lock
/about lock
/contact lock
```

Now:

```
/home updates
/about updates
```

can happen simultaneously.

Better throughput.

---

# Concepts Revised

## HashMap

```
O(1) lookup
O(1) update
```

Used for:

```
page -> hits
```

---

## Heap / Top-K

```
Max Heap
Min Heap of size K
```

Tradeoff:

```
O(N log N)
vs
O(N log K)
```

---

## Deque

Used for:

```
Sliding Window
```

Operations:

```java
addLast()
peekFirst()
pollFirst()
```

All:

```
O(1)
```

---

## Race Condition

Multiple threads update shared state simultaneously.

---

## Atomicity

Operation executes as one indivisible unit.

---

## Visibility

Changes made by one thread are visible to others.

---

## Coarse-Grained Locking

Lock whole object.

Simple but slow.

---

## Fine-Grained Locking

Lock smaller independent sections.

More concurrency.

---

## Key Takeaway

This single LLD problem covers:

* HashMaps
* Heaps
* Top-K queries
* Deques
* Sliding Window
* Memory optimization
* Caching strategies
* Race Conditions
* Atomicity
* Visibility
* Coarse vs Fine-Grained Locking
* Scalability tradeoffs

A very common interview warm-up because it combines both LLD and concurrency fundamentals.
