public class Stack {
    private final int[] arr;
    private int top;
    private final int size;

    public Stack(int length) {
        this.arr = new int[length];
        this.size = arr.length;
        this.top = -1;
    }

    public void push(int data) {
        if (top != size - 1)
            arr[++top] = data;
        else
            System.out.println("Stack full, cannot add: " + data);
    }

    public int pop() {
        if (top > -1)
            return arr[top--];
        else
            System.out.println("Stack empty");

        return -1;
    }

    public int peek() {
        if (top > -1)
            return arr[top];
        else
            System.out.println("Stack empty");

        return -1;
    }

    public void printStack() {
        for (Object num : arr) {
            System.out.print(num + " ");
        }
    }
}
