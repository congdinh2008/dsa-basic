import java.util.Stack;

/**
 * LinkedListTest
 */
public class StackLinkedListTest {

    public static void main(String[] args) {
        // Create stack with capacity
        MyStackLinkedList stack = new MyStackLinkedList();

        // Push value to stack
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(11);

        // List values from stack
        stack.traverse();

        System.out.println("Test pop:");
        System.out.println(stack.pop());

        System.out.println("Test peek:");
        System.out.println(stack.peek());
        System.out.println(stack.peek());


        Stack<String> disks = new Stack<String>();

        disks.push("Cong Dinh");
        disks.push("3.14");


        System.out.println(disks.pop());
        System.out.println(disks.pop());
    }
}