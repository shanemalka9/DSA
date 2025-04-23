package DataStructures.Queue;

/**
 * A basic fixed-size linear queue implementation using an array.
 * Note: This implementation does not wrap around once the rear reaches the end,
 * so even if there are free slots due to dequeues, we can't enqueue new elements
 * unless we shift or use a circular queue. Once rear reaches the array's length - 1,
 * no more elements can be enqueued even if there is space at the front.
 */
public class Queue {
    private int front = 0;   // Points to the front of the queue
    private int rear = -1;   // Points to the last added element
    private int size;        // Number of elements in the queue
    private int[] arr;       // Array to hold queue elements

    /**
     * Constructor to initialize the queue with a given size.
     * @param size the maximum capacity of the queue
     */
    public Queue(int size) {
        arr = new int[size];
    }

    /**
     * Adds an element to the end of the queue.
     * @param data the value to add
     */
    public void enqueue(int data) {
        arr[++rear] = data; // Move rear forward and add new element
        size++;             // Increment the number of elements
    }

    /**
     * Removes and returns the element from the front of the queue.
     * @return the value at the front
     */
    public int dequeue() {
        return arr[front++]; // Return and remove the front element
    }

    /**
     * Prints the current elements in the queue, along with front and rear positions.
     */
    public void printQueue() {
        for (int i = front; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("front at: " + arr[front]);
        System.out.println("rear at: " + arr[rear]);
    }
}
