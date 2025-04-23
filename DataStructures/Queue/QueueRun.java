package DataStructures.Queue;

public class QueueRun {
    public static void main(String[] args) {
        Queue queue = new Queue(4);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(5);
        queue.enqueue(99);


        queue.printQueue();

        queue.dequeue();

        queue.enqueue(12);


        queue.printQueue();
    }
}
