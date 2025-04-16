package DataStructures.LinkedList;

public class DoublyLinkedList {
    // Head of the list
    private DNode head = null;

    /**
     * Adds a new node with the given data to the end of the list.
     * @param data the value to add
     */
    public void add(int data) {
        DNode newNode = new DNode(data); // create a new node
        if (head == null) {           // if list is empty, new node becomes head
            head = newNode;
        } else {
            DNode current = head;
            // traverse to the last node
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            // link the new node at the end
            current.setNextNode(newNode);
            newNode.setPreviousNode(current);
        }
    }

    /**
     * Prints all node values in the list, from head to tail.
     */
    public void printForward() {
        DNode current = head;
        // walk through the list until the end
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }

    /**
     * Prints all node values in the list, from tail back to head.
     */
    public void printBackward() {
        if (head == null) {
            System.out.println();
            return;
        }
        // go to the tail first
        DNode current = head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        // traverse backwards
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPreviousNode();
        }
        System.out.println();
    }

    /**
     * Adds a new node with the given data to the beginning of the list.
     * @param data the value to add at the front
     */
    public void addFirst(int data) {
        DNode newNode = new DNode(data);    // create a new node
        if (head != null) {
            head.setPreviousNode(newNode);
            newNode.setNextNode(head);
        }
        head = newNode;                   // update head to new node
    }

    /**
     * Deletes the first node it finds with the given data.
     * If no such node exists, the list remains unchanged.
     * @param data the value to delete
     */
    public void delete(int data) {
        if (head == null) return; // nothing to delete in empty list

        // find the node to delete
        DNode current = head;
        while (current != null && current.getData() != data) {
            current = current.getNextNode();
        }
        if (current == null) return; // not found

        // if it's the head, shift head forward
        if (current == head) {
            head = head.getNextNode();
            if (head != null) {
                head.setPreviousNode(null);
            }
            return;
        }

        // bypass current
        DNode prev = current.getPreviousNode();
        DNode next = current.getNextNode();
        prev.setNextNode(next);
        if (next != null) {
            next.setPreviousNode(prev);
        }
    }
}

// DNode class updated to support doubly-linked behavior
class DNode {
    private DNode previousNode;   // reference to the previous node
    private int data;            // value held by this node
    private DNode nextNode;       // reference to the next node

    public DNode(int data) {
        this.data = data;
        this.previousNode = null;
        this.nextNode = null;
    }

    // Getter for data
    public int getData() {
        return data;
    }

    // Setter for data (included for completeness)
    public void setData(int data) {
        this.data = data;
    }

    // Getter for next node
    public DNode getNextNode() {
        return nextNode;
    }

    // Setter for next node reference
    public void setNextNode(DNode nextNode) {
        this.nextNode = nextNode;
    }

    // Getter for previous node
    public DNode getPreviousNode() {
        return previousNode;
    }

    // Setter for previous node reference
    public void setPreviousNode(DNode previousNode) {
        this.previousNode = previousNode;
    }
}
