# Data Structures and Algorithms (DSA)

A comprehensive repository for learning fundamental data structures and algorithms with Java implementations.

## Table of Contents
- [Overview](#overview)
- [Data Structures](#data-structures)
  - [Linked Lists](#linked-lists)
  - [Stack](#stack)
  - [Queue](#queue)
  - [Trees](#trees)
    - [Binary Trees](#binary-trees)
    - [Binary Search Trees (BST)](#binary-search-trees-bst)
    - [Tree Traversal](#tree-traversal)
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

**Implementation Details:**
- Each node contains: an integer value and a reference to the next node
- The list maintains a reference to the head node only
- Traversal is only possible in the forward direction

**Operations:**
- `add(data)`: Add node to the end
  1. Create a new node with the given data
  2. If head is null, set the new node as head
  3. Otherwise, traverse to the last node and set its next reference to the new node
- `addFirst(data)`: Add node to the beginning
  1. Create a new node with the given data
  2. Set the new node's next to the current head
  3. Update head to point to the new node
- `delete(data)`: Remove first node with matching data
  1. Handle special case: if head contains the target data, update head to head.next
  2. Otherwise, traverse the list until finding a node whose next node contains the target data
  3. Bypass the target node by updating the next reference
- `printValues()`: Print all node values
  1. Start at the head and traverse through the list
  2. Print each node's data value until reaching the end (null)

#### Doubly Linked List

A doubly linked list extends the singly linked list by adding a reference to the previous node, allowing for bidirectional traversal.

```
      +----------+         +----------+         +----------+
null<-| prev     |<------->| prev     |<------->| prev     |<-null
      | Node 1   |         | Node 2   |         | Node 3   |
      |     next |-------->|     next |-------->|     next |
      +----------+         +----------+         +----------+
```

**Implementation Details:**
- Each node contains: an integer value, a reference to the next node, and a reference to the previous node
- The list maintains a reference to the head node only
- Traversal is possible in both forward and backward directions

**Operations:**
- `add(data)`: Add node to the end
  1. Create a new node with the given data
  2. If head is null, set the new node as head
  3. Otherwise, traverse to the last node
  4. Set the last node's next to point to the new node
  5. Set the new node's previous to point to the last node
- `addFirst(data)`: Add node to the beginning
  1. Create a new node with the given data
  2. If head is not null, set head's previous to point to the new node
  3. Set the new node's next to the current head
  4. Update head to point to the new node
- `delete(data)`: Remove first node with matching data
  1. If head is null, return (nothing to delete)
  2. Find the node containing the target data
  3. If not found, return
  4. If it's the head, update head to head.next and set its previous to null
  5. Otherwise, update the previous node's next and the next node's previous to bypass the target node
- `printForward()`: Print all node values from head to tail
  1. Start at the head and traverse through the list using next references
  2. Print each node's data value until reaching the end (null)
- `printBackward()`: Print all node values from tail to head
  1. Start at the head and traverse to the last node using next references
  2. From the last node, traverse backwards using previous references
  3. Print each node's data value until reaching the beginning (null)

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

**Implementation Details:**
- Array-based implementation with fixed capacity
- Maintains a top index that points to the current top element
- Empty stack indicated by top = -1

**Operations:**
- `push(data)`: Add element to the top
  1. Check if stack is full (top == size-1)
  2. If not full, increment top and place new element at that position
  3. If full, display error message
- `pop()`: Remove and return the top element
  1. Check if stack is empty (top == -1)
  2. If not empty, return the element at top and decrement top
  3. If empty, display error message and return -1
- `peek()`: Return the top element without removing
  1. Check if stack is empty
  2. If not empty, return the element at top without changing top
  3. If empty, display error message and return -1
- `printStack()`: Print all stack elements
  1. Iterate through the array and print each element
  2. Indicate the top element

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

**Implementation Details:**
- Array-based implementation with fixed capacity
- Maintains front (for dequeue operations) and rear (for enqueue operations) indices
- Initial state: front = 0, rear = -1
- Does not wrap around when rear reaches the end (limitation of this implementation)

**Operations:**
- `enqueue(data)`: Add element at the rear
  1. Increment rear
  2. Place the new element at the rear position
  3. Increment size counter
- `dequeue()`: Remove and return element from the front
  1. Return the element at front position
  2. Increment front to move to the next element
- `printQueue()`: Print all queue elements
  1. Iterate from front to rear and print each element
  2. Show the current front and rear values

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

**Implementation Details:**
- Array-based implementation with fixed capacity
- Uses front, rear, and size to track queue state
- Uses modulo arithmetic to wrap around indices
- Initial state: front = 0, rear = 0, size = 0

**Operations:**
- `enqueue(data)`: Add element at the rear
  1. Check if queue is full (size == capacity)
  2. If not full, place new element at rear position
  3. Increment rear using modulo operation: rear = (rear + 1) % capacity
  4. Increment size
- `dequeue()`: Remove and return element from the front
  1. Check if queue is empty (size == 0)
  2. If not empty, get element at front position
  3. Increment front using modulo operation: front = (front + 1) % capacity
  4. Decrement size
  5. Return the removed element
- `isEmpty()`: Check if queue is empty
  1. Return true if size == 0, otherwise false
- `isFull()`: Check if queue is full
  1. Return true if size == capacity, otherwise false
- `printQueue()`: Print all queue elements
  1. Iterate through the queue elements using modulo arithmetic to handle wrapping
  2. Show the current front and rear positions

### Trees

Trees are hierarchical data structures with a root value and subtrees of children, represented as a set of linked nodes.

#### Binary Trees

A binary tree is a tree data structure in which each node has at most two children, referred to as the left child and the right child.

```
           10
          /  \
         5    15
        / \   / \
       3   7 12  18
```

**Implementation Details:**
- Each node contains: a value, a reference to the left child, and a reference to the right child
- A tree maintains a reference to the root node
- Operations can be performed recursively on subtrees

**Operations:**
- `insert(value)`: Add a new node to the tree
- `search(value)`: Find a value in the tree
- `delete(value)`: Remove a node with the given value
- `traversal()`: Visit all nodes in a specific order

#### Binary Search Trees (BST)

A binary search tree is a special type of binary tree where:
- The left subtree contains only nodes with values less than the node's value
- The right subtree contains only nodes with values greater than the node's value
- Both left and right subtrees are also BSTs

```
           10
          /  \
         5    15
        / \   / \
       3   7 12  18
```

**Implementation Details:**
- Follows all binary tree properties
- Maintains the BST property: left child < parent < right child
- Enables efficient searching, insertion, and deletion (O(log n) on average)

**Operations:**
- `insert(value)`: Add a new node while maintaining BST property
  1. Start at the root
  2. If value < current node, go to left subtree
  3. If value > current node, go to right subtree
  4. If null position is found, insert new node there
- `search(value)`: Find a value in the BST
  1. Start at the root
  2. If value equals current node value, return the node
  3. If value < current node value, search left subtree
  4. If value > current node value, search right subtree
  5. If leaf is reached without finding value, return null
- `delete(value)`: Remove a node while maintaining BST property
  1. Find the node to delete
  2. If node has no children, simply remove it
  3. If node has one child, replace node with its child
  4. If node has two children, find the inorder successor (smallest value in right subtree), replace node with it, and delete the successor

#### Tree Traversal

Tree traversal is the process of visiting each node in a tree exactly once. Different traversal methods yield different node orderings.

```
           10
          /  \
         5    15
        / \   / \
       3   7 12  18
```

**Depth-First Traversal Methods:**

1. **Inorder Traversal (Left → Root → Right)**
   - Process left subtree, then current node, then right subtree
   - For the tree above: 3, 5, 7, 10, 12, 15, 18
   - In a BST, this yields nodes in ascending order
   - Implementation:
     ```java
     void inOrder(Node root) {
         if (root != null) {
             inOrder(root.left);
             System.out.print(root.value + " ");
             inOrder(root.right);
         }
     }
     ```

2. **Preorder Traversal (Root → Left → Right)**
   - Process current node, then left subtree, then right subtree
   - For the tree above: 10, 5, 3, 7, 15, 12, 18
   - Useful for creating a copy of the tree or prefix expression evaluation
   - Implementation:
     ```java
     void preOrder(Node root) {
         if (root != null) {
             System.out.print(root.value + " ");
             preOrder(root.left);
             preOrder(root.right);
         }
     }
     ```

3. **Postorder Traversal (Left → Right → Root)**
   - Process left subtree, then right subtree, then current node
   - For the tree above: 3, 7, 5, 12, 18, 15, 10
   - Useful for deleting the tree or postfix expression evaluation
   - Implementation:
     ```java
     void postOrder(Node root) {
         if (root != null) {
             postOrder(root.left);
             postOrder(root.right);
             System.out.print(root.value + " ");
         }
     }
     ```

**Breadth-First Traversal Method:**

4. **Level Order Traversal**
   - Process nodes level by level, from left to right
   - For the tree above: 10, 5, 15, 3, 7, 12, 18
   - Useful for level-by-level processing and creating a breadth-first representation
   - Uses a queue to keep track of nodes to visit
   - Implementation:
     ```java
     void levelOrder(Node root) {
         if (root == null) return;
         
         Queue<Node> queue = new LinkedList<>();
         queue.add(root);
         
         while (!queue.isEmpty()) {
             Node current = queue.poll();
             System.out.print(current.value + " ");
             
             if (current.left != null)
                 queue.add(current.left);
             
             if (current.right != null)
                 queue.add(current.right);
         }
     }
     ```

**How Tree Traversal Works:**

Tree traversal algorithms leverage recursion or iteration to visit each node in the tree. The traversal process can be visualized as "walking" through the tree along a specific path:

1. **Recursive Implementation:**
   - Uses the call stack to implicitly track the traversal path
   - Each recursive call processes a subtree
   - The order of operations (visit node, process left, process right) determines the traversal type

2. **Iterative Implementation:**
   - Uses an explicit stack (for DFS) or queue (for BFS) to track nodes
   - Eliminates the risk of stack overflow for very deep trees
   - More complex to implement but more efficient for large trees

**Applications of Tree Traversal:**

- **Inorder:** Retrieving elements in sorted order from a BST
- **Preorder:** Creating a copy of the tree or generating prefix notation
- **Postorder:** Deleting a tree or generating postfix notation
- **Level Order:** Level-by-level processing, useful for visualizing tree structure

**Time and Space Complexity:**
- Time Complexity: O(n) - each node is visited exactly once
- Space Complexity:
  - Recursive: O(h) where h is the height of the tree (worst case O(n) for skewed trees)
  - Iterative: O(w) where w is the maximum width of the tree (worst case O(n) for complete trees at lowest level)

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

**Step-by-step process:**
1. Start at the first element (index 0)
2. Compare the current element with the target value
3. If they match, return the current index (search successful)
4. If they don't match, move to the next element
5. Repeat steps 2-4 until either:
   - A match is found (return the index)
   - The end of the array is reached (return "not found")

**Time Complexity:**
- Best case: O(1) - target is the first element
- Average case: O(n) - target is in the middle
- Worst case: O(n) - target is the last element or not present

**Space Complexity:** O(1) - uses constant extra space

#### Binary Search

Binary search works on sorted arrays by repeatedly dividing the search interval in half.

```
Array: [ 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 ]
                          ↑
                       Middle
                      
If target < middle:  [ 1 | 2 | 3 | 4 | 5 | - | - | - | - | - ]
If target > middle:  [ - | - | - | - | - | 6 | 7 | 8 | 9 | 10 ]
```

**Prerequisites:** The array must be sorted.

**Step-by-step process:**
1. Initialize `first` pointer to the beginning of the array (index 0)
2. Initialize `last` pointer to the end of the array (length - 1)
3. While `first` <= `last`:
   a. Calculate the middle index: `mid = (first + last) / 2`
   b. If array[mid] equals the target, return mid (search successful)
   c. If target > array[mid], set first = mid + 1 (search in right half)
   d. If target < array[mid], set last = mid - 1 (search in left half)
4. If the while loop exits without returning, the target is not in the array (return -1)

**Recursive implementation:**
1. Calculate the middle index: `mid = (first + last) / 2`
2. If array[mid] equals the target, return mid
3. If target > array[mid], recursively search the right half
4. If target < array[mid], recursively search the left half
5. Base case: If first > last, return -1 (not found)

**Time Complexity:**
- Best case: O(1) - target is the middle element
- Average and worst case: O(log n) - logarithmic time as the search space is halved in each step

**Space Complexity:** 
- Iterative: O(1) - constant extra space
- Recursive: O(log n) - due to the call stack

### Sort Algorithms

#### Bubble Sort

Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.

**Step-by-step process:**
1. Start at the beginning of the array
2. Compare each pair of adjacent elements
3. If they are in the wrong order (current > next), swap them
4. After each pass, the largest unsorted element "bubbles" to its correct position
5. Repeat steps 1-4 for n-1 passes, where n is the array length
6. Optimization: If no swaps occur in a pass, the array is already sorted

**Detailed example:**
```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

Pass 1: 
  Compare 6,5: Swap → [ 5 | 6 | 2 | 8 | 9 | 3 | 4 ]
  Compare 6,2: Swap → [ 5 | 2 | 6 | 8 | 9 | 3 | 4 ]
  Compare 6,8: No swap → [ 5 | 2 | 6 | 8 | 9 | 3 | 4 ]
  Compare 8,9: No swap → [ 5 | 2 | 6 | 8 | 9 | 3 | 4 ]
  Compare 9,3: Swap → [ 5 | 2 | 6 | 8 | 3 | 9 | 4 ]
  Compare 9,4: Swap → [ 5 | 2 | 6 | 8 | 3 | 4 | 9 ]
  End of Pass 1: Largest element (9) is at its correct position

Pass 2:
  Compare 5,2: Swap → [ 2 | 5 | 6 | 8 | 3 | 4 | 9 ]
  Compare 5,6: No swap → [ 2 | 5 | 6 | 8 | 3 | 4 | 9 ]
  Compare 6,8: No swap → [ 2 | 5 | 6 | 8 | 3 | 4 | 9 ]
  Compare 8,3: Swap → [ 2 | 5 | 6 | 3 | 8 | 4 | 9 ]
  Compare 8,4: Swap → [ 2 | 5 | 6 | 3 | 4 | 8 | 9 ]
  End of Pass 2: Second largest element (8) is at its correct position

...and so on until the array is fully sorted.
```

**Time Complexity:**
- Best case: O(n) - already sorted array with optimization
- Average and worst case: O(n²) - need to compare most pairs of elements

**Space Complexity:** O(1) - sorts in place with constant extra space

#### Selection Sort

Repeatedly selects the smallest (or largest) element from the unsorted portion and places it at the beginning (or end).

**Step-by-step process (for minimum selection sort):**
1. Divide the array into two parts: sorted (initially empty) and unsorted (initially the whole array)
2. Find the minimum element in the unsorted part
3. Swap it with the first element of the unsorted part
4. Expand the sorted part to include this new element
5. Repeat steps 2-4 until the entire array is sorted

**Detailed example:**
```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

Pass 1:
  Find minimum in positions 0-6: 2 at index 2
  Swap with first element: [ 2 | 5 | 6 | 8 | 9 | 3 | 4 ]
  Sorted portion: [2], Unsorted: [5,6,8,9,3,4]

Pass 2:
  Find minimum in positions 1-6: 3 at index 5
  Swap with position 1: [ 2 | 3 | 6 | 8 | 9 | 5 | 4 ]
  Sorted portion: [2,3], Unsorted: [6,8,9,5,4]

Pass 3:
  Find minimum in positions 2-6: 4 at index 6
  Swap with position 2: [ 2 | 3 | 4 | 8 | 9 | 5 | 6 ]
  Sorted portion: [2,3,4], Unsorted: [8,9,5,6]

...and so on until the array is fully sorted.
```

**Time Complexity:**
- Best, average, and worst case: O(n²) - always performs the same number of comparisons

**Space Complexity:** O(1) - sorts in place with constant extra space

#### Insertion Sort

Builds a sorted array one element at a time, by inserting each element in its proper position.

**Step-by-step process:**
1. Start with the second element (index 1)
2. Compare it with all elements in the sorted portion (to its left)
3. Shift elements greater than the current "key" one position to the right
4. Insert the key in its correct position
5. Move to the next element and repeat steps 2-4 until the end of the array

**Detailed example:**
```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

Pass 1 (key = 5):
  Compare 5 with 6: 5 < 6, shift 6 right
  Insert 5: [ 5 | 6 | 2 | 8 | 9 | 3 | 4 ]
  Sorted portion: [5,6], Unsorted: [2,8,9,3,4]

Pass 2 (key = 2):
  Compare 2 with 6: 2 < 6, shift 6 right
  Compare 2 with 5: 2 < 5, shift 5 right
  Insert 2: [ 2 | 5 | 6 | 8 | 9 | 3 | 4 ]
  Sorted portion: [2,5,6], Unsorted: [8,9,3,4]

Pass 3 (key = 8):
  Compare 8 with 6: 8 > 6, no shift needed
  Insert 8: [ 2 | 5 | 6 | 8 | 9 | 3 | 4 ]
  Sorted portion: [2,5,6,8], Unsorted: [9,3,4]

...and so on until the array is fully sorted.
```

**Time Complexity:**
- Best case: O(n) - already sorted array
- Average and worst case: O(n²) - need to shift most elements

**Space Complexity:** O(1) - sorts in place with constant extra space

#### Merge Sort

A divide-and-conquer algorithm that divides the array into halves, sorts each half, and then merges them.

**Step-by-step process:**
1. **Divide:** Split the array into two halves until each subarray has one element (a single element is considered sorted)
2. **Conquer:** Recursively sort each half
3. **Combine:** Merge the sorted halves to produce a single sorted array

**Detailed merge process:**
1. Create temporary arrays for left and right halves
2. Copy data to these temporary arrays
3. Compare elements from both arrays and place the smaller one in the original array
4. If one array is exhausted, copy the remaining elements from the other array

**Detailed example:**
```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

Divide into halves:
  [ 6 | 5 | 2 | 8 ] and [ 9 | 3 | 4 ]

Further divide:
  [ 6 | 5 ] and [ 2 | 8 ] and [ 9 ] and [ 3 | 4 ]

Further divide until single elements:
  [ 6 ] [ 5 ] [ 2 ] [ 8 ] [ 9 ] [ 3 ] [ 4 ]

Merge phase (conquer):
  Merge [6] and [5] → [5,6]
  Merge [2] and [8] → [2,8]
  Merge [3] and [4] → [3,4]

  Merge [5,6] and [2,8] → [2,5,6,8]
  Merge [9] and [3,4] → [3,4,9]

  Merge [2,5,6,8] and [3,4,9] → [2,3,4,5,6,8,9]
```

**Time Complexity:**
- Best, average, and worst case: O(n log n) - divide step takes O(log n) time, merge step takes O(n) time

**Space Complexity:** O(n) - requires additional space for temporary arrays

#### Quick Sort

Another divide-and-conquer algorithm that partitions the array based on a pivot element.

**Step-by-step process:**
1. **Select a pivot:** Usually the last element (other strategies exist)
2. **Partition:** Rearrange the array so that:
   - All elements less than the pivot are to its left
   - All elements greater than the pivot are to its right
   - The pivot is in its final position
3. **Divide:** Recursively sort the sub-arrays to the left and right of the pivot

**Detailed partition process:**
1. Choose the rightmost element as pivot
2. Initialize index i = low - 1 (to track the boundary of smaller elements)
3. For each element from low to high-1:
   - If current element < pivot, increment i and swap arr[i] with current element
4. Swap pivot (arr[high]) with arr[i+1]
5. Return i+1 as the partition point

**Detailed example:**
```
Initial: [ 6 | 5 | 2 | 8 | 9 | 3 | 4 ]

First partition (pivot = 4):
  Compare each element with pivot (4):
  - 6 > 4: No action
  - 5 > 4: No action
  - 2 < 4: Increment i (0), swap arr[0] with arr[2] → [2|5|6|8|9|3|4]
  - 8 > 4: No action
  - 9 > 4: No action
  - 3 < 4: Increment i (1), swap arr[1] with arr[5] → [2|3|6|8|9|5|4]
  Place pivot: swap arr[2] with arr[6] → [2|3|4|8|9|5|6]
  Pivot (4) is now at position 2

Recursively sort left partition [2,3] and right partition [8,9,5,6]:
  Left partition [2,3] is already sorted

  Right partition [8,9,5,6]:
    Choose pivot (6)
    Partition process: [5|8|9|6] → [5|6|9|8]
    Recursively sort [5] and [9,8]
      [5] is already sorted
      [9,8] → [8,9]

Final sorted array: [2,3,4,5,6,8,9]
```

**Time Complexity:**
- Best and average case: O(n log n) - balanced partitioning
- Worst case: O(n²) - unbalanced partitioning (happens with already sorted arrays)

**Space Complexity:**
- Average: O(log n) - for the recursion stack
- Worst: O(n) - for the recursion stack in worst case

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

## When to Use Which Data Structure or Algorithm

### Data Structures

**Linked List:**
- Use when you need frequent insertions and deletions
- Use when the size is not known in advance or may change dynamically
- Use when random access is not required
- Doubly linked lists are preferred when you need to traverse both forward and backward

**Stack:**
- Use for problems involving last-in-first-out (LIFO) operations
- Applications: Function call management, expression evaluation, undo mechanisms
- Use when you only need to access elements at one end of the collection

**Queue:**
- Use for problems involving first-in-first-out (FIFO) operations
- Applications: Task scheduling, breadth-first search, buffering
- Use when you need to process items in the exact order they were added
- Circular queues are efficient for fixed-size queue implementations

### Algorithms

**Search Algorithms:**
- **Linear Search:** Use for unsorted arrays or when the array is very small
- **Binary Search:** Use for sorted arrays when quick lookups are required

**Sort Algorithms:**
- **Bubble Sort:** Rarely used in practice due to inefficiency, but simple to implement
- **Selection Sort:** Use for small arrays or when memory writes are expensive
- **Insertion Sort:** Use for small arrays or nearly sorted arrays
- **Merge Sort:** Use when stable sort is required and extra memory usage is not a concern
- **Quick Sort:** Use for general-purpose sorting when average performance matters more than worst-case scenarios

## Contributing

Contributions are welcome! If you'd like to add new data structures, algorithms, or improve existing implementations:

1. Fork the repository
2. Create your feature branch
3. Commit your changes with detailed comments
4. Push to your branch
5. Submit a pull request with a clear description of your improvements

When contributing, please ensure:
- Code is well-commented and follows Java best practices
- Each implementation includes a brief explanation of its functionality
- Time and space complexity are documented
- Examples demonstrating usage are provided
