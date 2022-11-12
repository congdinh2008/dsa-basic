public class QueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);

        System.out.println("Test enqueue");
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

        System.out.println("Test dequeue: ");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
