package java;
public class StackTest {
    public static void main(String[] args) {
        // Create stack with capacity
        MyStack stack = new MyStack(5);

        // Push value to stack
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(11);

        System.out.println("Stack capacity: " + stack.getCapacity());

        // List values from stack
        stack.traverse();

        System.out.println("Test pop:");
        System.out.println(stack.pop());

        System.out.println("Test peek:");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }
}
