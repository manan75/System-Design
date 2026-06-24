# Design an In-Memory Unix-like File System

## Problem Statement

Design an in-memory Unix-like file system supporting:

### 1. mkdir(path)

Create directories along the given path.

Example:

```text
mkdir("/home/manan/projects")
```

Creates:

```text
/
└── home
    └── manan
        └── projects
```

Assume **mkdir -p** behavior, i.e., missing intermediate directories are created automatically.

---

### 2. cd(path)

Change the current working directory.

Examples:

```text
cd("/home/manan")
cd("../temp")
cd("./projects")
```

Support:

* Absolute paths (`/home/manan`)
* Relative paths (`projects`)
* Current directory (`.`)
* Parent directory (`..`)

---

### 3. pwd()

Return the current working directory.

Example:

```text
Current Directory:
/home/manan/projects
```

Output:

```text
/home/manan/projects
```

---

### 4. Wildcard Support (*)

`*` represents any directory at the current level.

Example:

```text
/
├── home
│   └── manan
└── temp
```

```text
cd("*/manan")
```

Matches:

```text
home/manan
```

and changes the current directory there.

If multiple matches exist, return the first match found during DFS traversal.

---

## Core Concepts

* Trees
* N-ary Trees
* Parent Pointers
* HashMap
* DFS / Backtracking
* Path Parsing
* Object-Oriented Design

---

# Design

## Directory

```java
class Directory {
    String name;
    Directory parent;
    Map<String, Directory> children;
}
```

### Why Parent Pointer?

Needed for:

```text
cd("..")
pwd()
```

without traversing from the root.

---

## FileSystem

```java
class FileSystem {

    Directory root;
    Directory currentDirectory;

    void mkdir(String path);

    void cd(String path);

    String pwd();

    Directory resolvePath(String path);
}
```

---

# Path Parsing

Helper used by all operations:

```java
private List<String> getTokens(String path)
```

Example:

```text
"/home/manan/projects"
```

becomes:

```text
["home", "manan", "projects"]
```

---

# mkdir()

### Approach

1. Split path into tokens.
2. Start from root.
3. For every token:

   * If child exists → move to child.
   * Else create child and move to it.

### Complexity

```text
O(depth)
```

---

# resolvePath()

Single helper handling:

```text
Absolute paths
Relative paths
.
..
```

### Absolute Path

```text
/home/manan
```

Start traversal from:

```text
root
```

### Relative Path

```text
projects/java
```

Start traversal from:

```text
currentDirectory
```

### Parent

```text
..
```

Move to:

```text
parent
```

### Current Directory

```text
.
```

Do nothing.

### Complexity

```text
O(depth)
```

---

# cd()

Implementation:

```java
currentDirectory = resolvePath(path);
```

Complexity:

```text
O(depth)
```

---

# pwd()

### Approach

Use parent pointers.

Example:

```text
projects
 ↑
manan
 ↑
home
 ↑
root
```

Collect names while moving upward:

```text
projects
manan
home
```

Reverse:

```text
home
manan
projects
```

Build:

```text
/home/manan/projects
```

### Complexity

```text
O(depth)
```

---

# Wildcard Support (*)

### Meaning

`*` matches any directory name at the current level.

Example:

```text
/
├── users
│   └── john
└── admin
    └── john
```

```text
cd("*/john")
```

Possible matches:

```text
/users/john
/admin/john
```

Return the first match found.

---

## DFS Helper

```java
Directory wildcardDFS(
    Directory curr,
    List<String> tokens,
    int index
)
```

### Logic

If token is:

```text
*
```

Try every child:

```text
users
admin
...
```

and recursively attempt to match the remaining path.

### Complexity

Worst Case:

```text
O(N)
```

where N is the number of directories explored.

---

# Time Complexities

| Operation   | Complexity      |
| ----------- | --------------- |
| mkdir       | O(depth)        |
| cd          | O(depth)        |
| pwd         | O(depth)        |
| resolvePath | O(depth)        |
| wildcard cd | O(N) worst case |
| rmdir       | O(depth)        |

---

# Follow-Ups

## 1. ls()

### Problem

List all children inside a directory.

Example:

```text
ls("/home/manan")
```

Output:

```text
projects
docs
photos
```

### Solution

```java
Directory dir = resolvePath(path);
```

Iterate:

```java
dir.getChildren().values()
```

### Complexity

```text
O(number of children)
```

---

## 2. rmdir()

### Problem

Delete a directory.

Example:

```text
rmdir("/home/manan")
```

### Solution

1. Resolve the directory.
2. Find its parent.
3. Remove it from parent's map.

```java
parent.getChildren().remove(dir.getName());
```

Entire subtree becomes unreachable and is cleaned up by Java Garbage Collector.

### Edge Cases

* Cannot delete root.
* Optionally disallow deleting current working directory.

### Complexity

```text
O(depth)
```

---

## 3. Support Files

### Initial Approach

```java
Map<String, Directory> directories;
Map<String, File> files;
```

### Better Design

Introduce:

```java
abstract class Node
```

```java
Node
├── Directory
└── File
```

```java
class Directory extends Node {
    Map<String, Node> children;
}
```

```java
class File extends Node {
    String content;
}
```

Benefits:

* Cleaner OO design
* Easier ls()
* Easier rm()
* Easy future extensions

---

## 4. Recursive Wildcard (**)

Current:

```text
*
```

matches exactly one level.

New:

```text
**
```

matches any depth.

Example:

```text
cd("**/john")
```

Requires full subtree DFS.

---

## 5. Thread Safety

Multiple users may call:

```text
mkdir
cd
rmdir
```

simultaneously.

Possible solutions:

```java
synchronized
```

or

```java
ReadWriteLock
```

---

## 6. Faster Path Lookup

Current:

```text
O(depth)
```

Maintain:

```java
Map<String, Directory> pathMap;
```

Example:

```text
"/home/manan/projects"
        ->
Directory Object
```

Tradeoff:

```text
More memory
Faster lookup
```

---

## 7. Multiple Users

Current design:

```java
Directory currentDirectory;
```

supports only one user.

For multiple users:

```java
Map<UserId, Directory> userWorkingDirectory;
```

Each user maintains their own current directory.

---

## 8. Permissions

Store:

```java
owner
permissions
```

inside each node.

Example:

```text
rwx
```

Validate permissions before:

```text
cd
mkdir
rmdir
rm
```

---

## 9. Undo

Maintain:

```java
Stack<Operation>
```

Each mutating operation pushes an inverse action.

Examples:

### mkdir

Undo:

```text
rmdir(createdDirectory)
```

### rmdir

Store deleted subtree.

Undo:

```text
restore subtree into parent
```

Related Design Pattern:

```text
Memento Pattern
```

or

```text
Command Pattern with Undo
```

---

## 10. Sorted ls()

Current:

```java
HashMap<String, Directory>
```

If alphabetical output is required:

```java
TreeMap<String, Directory>
```

Iteration automatically becomes sorted.
