/**
 * LinkedListTest
 */
public class QueueLinkedListTest {

    public static void main(String[] args) {
        MyQueueLinkedList queue = new MyQueueLinkedList();

        System.out.println("Test enqueue");
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

        System.out.println("Front of queue: " + queue.front());
        System.out.println("Rear of queue: " + queue.rear());

        System.out.println("Queue elements: ");
        queue.traverse();

        System.out.println("Test dequeue: ");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}