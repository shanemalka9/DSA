public class Stack {
    // Underlying array to store stack elements
    private final int[] arr;
    // Index of the top element in the stack
    private int top;
    // Maximum capacity of the stack
    private final int size;

    /**
     * Constructs a new Stack with the given capacity.
     * @param length the maximum number of elements the stack can hold
     */
    public Stack(int length) {
        this.arr = new int[length];   // initialize storage array
        this.size = arr.length;       // set capacity
        this.top = -1;                // empty stack indicated by top = -1
    }

    /**
     * Pushes an element onto the top of the stack.
     * If the stack is full, prints an error message.
     * @param data the value to push onto the stack
     */
    public void push(int data) {
        if (top != size - 1) { // check for available space
            arr[++top] = data; // increment top, then store value
        } else {
            System.out.println("Stack full, cannot add: " + data);
        }
    }

    /**
     * Pops the top element off the stack and returns it.
     * If the stack is empty, prints an error and returns -1.
     * @return the popped value, or -1 if stack is empty
     */
    public int pop() {
        if (top > -1) { // ensure stack is not empty
            return arr[top--]; // return value then decrement top
        } else {
            System.out.println("Stack empty");
            return -1;
        }
    }

    /**
     * Peeks at the top element without removing it.
     * If the stack is empty, prints an error and returns -1.
     * @return the top value, or -1 if stack is empty
     */
    public int peek() {
        if (top > -1) {
            return arr[top]; // return current top value
        } else {
            System.out.println("Stack empty");
            return -1;
        }
    }

    /**
     * Prints the entire stack array (including unused slots) from bottom to top.
     */
    public void printStack() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("Top at: " + arr[top]);
    }
}
