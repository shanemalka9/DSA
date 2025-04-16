package DataStructures.LinkedList;

public class LinkedListRun {
    public static void main(String[] args) {
        // ============================
        // Test Singly Linked List
        // ============================
        SinglyLinkedList sList = new SinglyLinkedList();

        // Add three values to the end
        sList.add(5);
        sList.add(7);
        sList.add(6);
        System.out.println("SinglyList – added values:");
        sList.printValues();         // expected: 5 7 6

        // Add a value at the front
        sList.addFirst(8);
        System.out.println("SinglyList – after addFirst(8):");
        sList.printValues();         // expected: 8 5 7 6

        // Delete the node with value 7
        sList.delete(7);
        System.out.println("SinglyList – after delete(7):");
        sList.printValues();         // expected: 8 5 6

        System.out.println();        // blank line for separation

        // ============================
        // Test Doubly Linked List
        // ============================
        DoublyLinkedList dList = new DoublyLinkedList();

        // Add three values to the end
        dList.add(5);
        dList.add(7);
        dList.add(6);
        System.out.println("DoublyList – added values (forward):");
        dList.printForward();        // expected: 5 7 6
        System.out.println("DoublyList – added values (backward):");
        dList.printBackward();       // expected: 6 7 5

        // Add a value at the front
        dList.addFirst(8);
        System.out.println("DoublyList – after addFirst(8) (forward):");
        dList.printForward();        // expected: 8 5 7 6
        System.out.println("DoublyList – after addFirst(8) (backward):");
        dList.printBackward();       // expected: 6 7 5 8

        // Delete the node with value 7
        dList.delete(7);
        System.out.println("DoublyList – after delete(7) (forward):");
        dList.printForward();        // expected: 8 5 6
        System.out.println("DoublyList – after delete(7) (backward):");
        dList.printBackward();       // expected: 6 5 8
    }
}
