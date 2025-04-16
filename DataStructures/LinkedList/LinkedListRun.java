package DataStructures.LinkedList;

public class LinkedListRun {
    public static void main(String[] args) {
        LinkedList nums = new LinkedList();

        // Add three values to the end
        nums.add(5);
        nums.add(7);
        nums.add(6);
        System.out.println("Added values:");
        nums.printValues(); // should print: 5 7 6

        // Add a value at the front
        nums.addFirst(8);
        System.out.println("Added a value to the beginning:");
        nums.printValues(); // should print: 8 5 7 6

        // Delete the node with value 7
        nums.delete(7);
        System.out.println("Deleted value 7:");
        nums.printValues(); // should print: 8 5 6
    }
}
