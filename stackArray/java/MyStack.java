package java;
/**
 * MyStack
 */
public class MyStack {

    private int capacity;
    private int top;
    private int items[];

    MyStack(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
        this.top = -1;
    }

    public int getCapacity() {
        return capacity;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top < 0;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top >= capacity - 1;
    }

    // Push value to stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow: Cannot push " + x);
        } else {
            items[++top] = x;
        }
    }

    // Pop value from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            int x = items[top--];
            return x;
        }
    }

    // Peek value from stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            int x = items[top];
            return x;
        }
    }

    // List value from stack
    public void traverse() {
        System.out.println("Stack elements:");
        for (int i = top; i > -1; i--) {
            System.out.println(items[i]);
        }
    }
}