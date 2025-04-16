package DataStructures.LinkedList;

public class SinglyLinkedList {
    // Head of the list
    private Node head = null;

    /**
     * Adds a new node with the given data to the end of the list.
     * @param data the value to add
     */
    public void add(int data) {
        Node newNode = new Node(data); // create a new node
        Node current = head;

        if (head == null) { // if list is empty, new node becomes head
            head = newNode;
        } else {
            // traverse to the last node
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            // link the new node at the end
            current.setNextNode(newNode);
        }
    }

    /**
     * Prints all node values in the list, from head to tail.
     */
    public void printValues() {
        Node current = head;
        // walk through the list until the end
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNextNode();
        }
        System.out.println(); // newline after printing all values
    }

    /**
     * Adds a new node with the given data to the beginning of the list.
     * @param data the value to add at the front
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);    // create a new node
        newNode.setNextNode(head);        // point it to current head
        head = newNode;                   // update head to new node
    }

    /**
     * Deletes the first node it finds with the given data.
     * If no such node exists, the list remains unchanged.
     * @param data the value to delete
     */
    public void delete(int data) {
        if (head == null) return; // nothing to delete in empty list

        // special case: if head holds the data, remove it
        if (head.getData() == data) {
            head = head.getNextNode();
            return;
        }

        Node current = head;
        // find the node just before the one to delete
        while (current.getNextNode() != null && current.getNextNode().getData() != data) {
            current = current.getNextNode();
        }

        // if next node matches, bypass it
        if (current.getNextNode() != null) {
            current.setNextNode(current.getNextNode().getNextNode());
        }
    }
}

// Simple node class for our LinkedList
class Node {
    private int data;         // value held by this node
    private Node nextNode;    // reference to the next node

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    // Getter for data
    public int getData() {
        return this.data;
    }

    // Setter for data (not used, but provided for completeness)
    public void setData(int data) {
        this.data = data;
    }

    // Getter for the next node
    public Node getNextNode() {
        return this.nextNode;
    }

    // Setter for the next node reference
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
