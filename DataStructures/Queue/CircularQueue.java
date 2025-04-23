package DataStructures.Queue;

/**
 * A Circular Queue implementation using an array.
 * Unlike a linear queue, a circular queue wraps around when it reaches the end of the array.
 * This allows efficient use of space and prevents the issue where the rear pointer cannot move forward
 * just because it's at the end of the array while there might be free slots at the front.
 */
public class CircularQueue {
    private int front = 0;      // Points to the front of the queue
    private int rear = 0;       // Points to the position where the next element will be inserted
    private int size = 0;       // Tracks the number of elements currently in the queue
    private int capacity;       // Maximum number of elements the queue can hold
    private int[] arr;          // Array to store queue elements

    /**
     * Constructor to initialize the circular queue with a fixed capacity.
     * @param capacity the total capacity of the circular queue
     */
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    /**
     * Checks whether the queue is full.
     * @return true if the queue is full, otherwise false
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Checks whether the queue is empty.
     * @return true if the queue is empty, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element to the rear of the queue.
     * Wraps around if the rear reaches the end of the array.
     * @param data the element to add
     */
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        arr[rear] = data;
        rear = (rear + 1) % capacity; // wrap around
        size++;
    }

    /**
     * Removes and returns the front element from the queue.
     * Wraps around if the front reaches the end of the array.
     * @return the removed element, or -1 if the queue is empty
     */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // or throw exception
        }
        int removed = arr[front];
        front = (front + 1) % capacity; // wrap around
        size--;
        return removed;
    }

    /**
     * Prints the elements of the queue in the correct order.
     * Handles wrapping around of indices.
     */
    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
        System.out.println("front at: " + front);
        System.out.println("rear at: " + rear);
    }
}
