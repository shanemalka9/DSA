public class StackRun {
    public static void main(String[] args) {
        Stack nums = new Stack(5);

        nums.pop();
        nums.peek();

        nums.push(10);
        nums.push(30);
        nums.push(20);
        nums.push(40);
        nums.push(60);
        System.out.println("Pop: " + nums.pop());
        nums.push(50);
        System.out.println("Peek: " + nums.peek());

        nums.printStack();
    }
}
