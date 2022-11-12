package java;
public class MyQueueLinkedList {
    int front, rear, size;
    MyLinkedList list;

    public MyQueueLinkedList() {
        list = new MyLinkedList();
    }

    // Get size of the queue
    public int size() {
        return list.size();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Add an item to the queue.
    // It changes rear and size
    public void enqueue(int item) {
        list.addLast(item);
        this.size++;
    }

    // Get an item from queue.
    // It changes front and size
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int item = list.getHead();
        list.deleteFirst();
        this.size--;
        return item;
    }

    // Get front of queue
    public int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return list.getHead();
    }

    // Get rear of queue
    public int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return list.getTail();
    }

    public void traverse(){
        list.traverse();
    }
}