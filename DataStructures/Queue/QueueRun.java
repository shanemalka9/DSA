package DataStructures.Queue;

public class QueueRun {
    public static void main(String[] args) {
        // Normal Queue
        System.out.println("Normal Queue");
        Queue queue = new Queue(4);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(5);
        queue.enqueue(99);


        queue.printQueue();

        queue.dequeue();

        // queue.enqueue(12);

        queue.printQueue();

        // Circular Queue
        System.out.println("\nCircular Queue");
        CircularQueue cQueue = new CircularQueue(4);

        cQueue.enqueue(10);
        cQueue.enqueue(20);
        cQueue.enqueue(5);
        cQueue.enqueue(99);


        cQueue.printQueue();

        cQueue.dequeue();

        cQueue.enqueue(12);


        cQueue.printQueue();
    }
}
