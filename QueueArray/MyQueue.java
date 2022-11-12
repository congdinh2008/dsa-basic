public class MyQueue {
    int front, rear, size;
    int capacity;
    int array[];

    public MyQueue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    // Get size of the queue
    public int size() {
        return size;
    }

    // Get capacity of the queue
    public int getCapacity() {
        return capacity;
    }

    // Check if the queue is full
    public boolean isFull() {
        return (size == capacity);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    // Add an item to the queue.
    // It changes rear and size
    public void enqueue(int item) {
        if (isFull())
            return;
        this.rear = (this.rear + 1)
                % this.capacity;
        this.array[this.rear] = item;
        this.size++;
        System.out.println(item
                + " enqueued to queue");
    }

    // Get an item from queue.
    // It changes front and size
    public int dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1)
                % this.capacity;
        this.size--;
        return item;
    }

    // Get front of queue
    public int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    // Get rear of queue
    public int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }
}