# Data Structures and Algorithms (DSA)

A comprehensive repository for learning fundamental data structures and algorithms with Java implementations.

## Table of Contents
- [Overview](#overview)
- [Data Structures](#data-structures)
  - [Linked Lists](#linked-lists)
  - [Stack](#stack)
  - [Queue](#queue)
- [Algorithms](#algorithms)
  - [Search Algorithms](#search-algorithms)
  - [Sort Algorithms](#sort-algorithms)
- [Usage](#usage)
- [Contributing](#contributing)

## Overview

This repository contains Java implementations of common data structures and algorithms. Each implementation includes detailed comments explaining the logic and functionality, making it an excellent resource for learning DSA concepts.

## Data Structures

### Linked Lists

#### Singly Linked List

A singly linked list is a linear data structure where each element (node) contains data and a reference to the next node in the sequence.

```
[ Node 1 | ]--->[ Node 2 | ]--->[ Node 3 | ]---> null
  data next     data  next      data  next
```

Operations:
- `add(data)`: Add node to the end
- `addFirst(data)`: Add node to the beginning
- `delete(data)`: Remove first node with matching data
- `printValues()`: Print all node values

#### Doubly Linked List

A doubly linked list extends the singly linked list by adding a reference to the previous node, allowing for bidirectional traversal.

```
      +----------+         +----------+         +----------+
null<-| prev     |<------->| prev     |<------->| prev     |<-null
      | Node 1   |         | Node 2   |         | Node 3   |
      |     next |-------->|     next |-------->|     next |
      +----------+         +----------+         +----------+
```

Operations:
- `add(data)`: Add node to the end
- `addFirst(data)`: Add node to the beginning
- `delete(data)`: Remove first node with matching data
- `printForward()`: Print all node values from head to tail
- `printBackward()`: Print all node values from tail to head

### Stack

A stack is a LIFO (Last-In-First-Out) data structure where elements are added and removed from the same end, called the top.

```
          │ 60 │ ← Top
          ├────┤
          │ 40 │
          ├────┤
          │ 20 │
          ├────┤
          │ 30 │
          ├────┤
          │ 10 │
          └────┘
```

Operations:
- `push(data)`: Add element to the top
- `pop()`: Remove and return the top element
- `peek()`: Return the top element without removing
- `printStack()`: Print all stack elements

### Queue

#### Linear Queue

A basic queue implementation that follows FIFO (First-In-First-Out) principle with elements added at the rear and removed from the front.

```
      Front                        Rear
        ↓                           ↓
┌────┬────┬────┬────┐           ┌────┐
│ 20 │ 5  │ 99 │    │ Enqueue → │    │
└────┴────┴────┴────┘           └────┘
```

Operations:
- `enqueue(data)`: Add element at the rear
- `dequeue()`: Remove and return element from the front
- `printQueue()`: Print all queue elements

#### Circular Queue

An improved queue implementation that efficiently uses memory by wrapping around when reaching the end of the array.

```
        ┌───────────────────────────┐
        │                           │
        ▼                           │
┌────┬────┬────┬────┐               │
│ 12 │ 20 │ 5  │ 99 │               │
└────┴────┴────┴────┘               │
  ▲              │                  │
  │              │                  │
  └──────────────┘                  │
       Dequeue     Enqueue          │
                      └─────────────┘
```

Operations:
- `enqueue(data)`: Add element at the rear (wraps around if needed)
- `dequeue()`: Remove and return element from the front (wraps around if needed)
- `isEmpty()`: Check if queue is empty
- `isFull()`: Check if queue is full
- `printQueue()`: Print all queue elements

## Algorithms

### Search Algorithms

#### Linear Search

Linear search sequentially checks each element of the array until a match is found or the array ends.

```
Array: [ 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 ]
        ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑   ↑
Check:  1→  2→  3→  4→  5→  6→  7→  8→  9→  10
                           Found!
```

Time Complexity: O(n)

#### Binary Search

Binary search works on sorted arrays by repeatedly dividing the search interval in half.

```
Array: [ 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 ]
                          ↑
                       Middle
                      
If target < middle:  [ 1 | 2 | 3 | 4 | 5 | - | - | - | - | - ]
If target > middle:  [ - | - | - | - | - | 6 | 7 | 8 | 9 | 10 ]
```

Time Complexity: O(log n)

### Sort Algorithms

#### Bubble Sort

Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.

```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

Pass 1:  [ 5 | 6 | 2 | 8 | 9 | 3 | 4 ]  (Swap 6,5)
         [ 5 | 2 | 6 | 8 | 9 | 3 | 4 ]  (Swap 6,2)
         [ 5 | 2 | 6 | 8 | 9 | 3 | 4 ]  (No swap 8,6)
         [ 5 | 2 | 6 | 8 | 9 | 3 | 4 ]  (No swap 9,8)
         [ 5 | 2 | 6 | 8 | 3 | 9 | 4 ]  (Swap 9,3)
         [ 5 | 2 | 6 | 8 | 3 | 4 | 9 ]  (Swap 9,4)
```

Time Complexity: O(n²)

#### Selection Sort

Repeatedly selects the minimum element from the unsorted portion and places it at the beginning.

```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

Pass 1:  [ 2 | 5 | 6 | 8 | 9 | 3 | 4 ]  (Found min 2, swap with 6)
Pass 2:  [ 2 | 3 | 6 | 8 | 9 | 5 | 4 ]  (Found min 3, swap with 5)
Pass 3:  [ 2 | 3 | 4 | 8 | 9 | 5 | 6 ]  (Found min 4, swap with 6)
```

Time Complexity: O(n²)

#### Insertion Sort

Builds a sorted array one element at a time, by inserting each element in its proper position.

```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

Pass 1:  [ 5 | 6 | 2 | 8 | 9 | 3 | 4 ]  (Insert 5 before 6)
Pass 2:  [ 2 | 5 | 6 | 8 | 9 | 3 | 4 ]  (Insert 2 at beginning)
Pass 3:  [ 2 | 5 | 6 | 8 | 9 | 3 | 4 ]  (8 already in position)
```

Time Complexity: O(n²)

#### Merge Sort

A divide-and-conquer algorithm that divides the array into halves, sorts each half, and then merges them.

```
                  [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]
                   /                     \
         [ 6 | 5 | 2 | 8 ]          [ 9 | 3 | 4 ]
          /         \                 /       \
    [ 6 | 5 ]    [ 2 | 8 ]      [ 9 ]    [ 3 | 4 ]
     /   \        /   \          |        /   \
  [ 6 ] [ 5 ]  [ 2 ] [ 8 ]    [ 9 ]    [ 3 ] [ 4 ]
     \   /        \   /          |        \   /
    [ 5 | 6 ]    [ 2 | 8 ]    [ 9 ]    [ 3 | 4 ]
          \         /                     \   /
         [ 2 | 5 | 6 | 8 ]            [ 3 | 4 | 9 ]
                   \                     /
                  [ 2 | 3 | 4 | 5 | 6 | 8 | 9 ]
```

Time Complexity: O(n log n)

#### Quick Sort

Another divide-and-conquer algorithm that selects a pivot element and partitions the array around it.

```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

Choose pivot (4):
             pivot
             ↓
[ 2 | 3 | 4 | 6 | 8 | 9 | 5 ]
  ←smaller→   ←larger→

Recursively sort subarrays:
[ 2 | 3 ] pivot=4 [ 6 | 8 | 9 | 5 ]
```

Time Complexity: Average O(n log n), Worst O(n²)

## Usage

Each data structure and algorithm has its own runner class that demonstrates its functionality. To run any example:

1. Navigate to the specific directory
2. Compile the Java files
3. Run the appropriate runner class

For example:
```bash
# For Stack example
javac DataStructures/Stack/Stack.java DataStructures/Stack/StackRun.java
java DataStructures.Stack.StackRun

# For Binary Search example
javac Algorithms/Search_Algorithms/BinarySearch/BinarySearch.java
java Algorithms.Search_Algorithms.BinarySearch.BinarySearch
```

## Contributing

Contributions are welcome! If you'd like to add new data structures, algorithms, or improve existing implementations:

1. Fork the repository
2. Create your feature branch
3. Commit your changes with detailed comments
4. Push to your branch