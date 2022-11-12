public class MyStackLinkedList {
    MyLinkedList list;

    public MyStackLinkedList(){
        list = new MyLinkedList();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Push value to stack
    public void push(int x) {
        list.addFirst(x);
    }

    // Pop value from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        } else {
            int result = list.getHead();
            list.deleteFirst();
            return result;
        }
    }

    // Peek value from stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        } else {
            return list.getHead();
        }
    }

    // List value from stack
    public void traverse() {
        System.out.println("Stack elements:");
        list.traverse();
    }
}
