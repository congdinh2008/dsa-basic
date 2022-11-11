/**
 * LinkedListTest
 */
public class LinkedListTest {

    public static void main(String[] args) {
        MyCustomLinkedList list = new MyCustomLinkedList();

        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(3);

        System.out.println("List after add 3 value at first: ");
        list.traverse();

        System.out.println("Number of elements: ");
        System.out.println(list.size());

        list.addLast(0);
        list.addLast(11);

        System.out.println("List after add 2 value at last: ");
        list.traverse();

        System.out.println("Number of elements: ");
        System.out.println(list.size());

        System.out.println("Value of head: ");
        System.out.println(list.getHead());

        System.out.println("Value of tail: ");
        System.out.println(list.getTail());

        list.addAfter(list.getNodeByIndex(1), 17);

        System.out.println("List after add 17 after second node: ");
        list.traverse();

        list.deleteFirst();
        System.out.println("List after delete the first node: ");
        list.traverse();

        list.deleteLast();
        System.out.println("List after delete the last node: ");
        list.traverse();

        list.deleteAtIndex(1);
        System.out.println("List after delete a node with index = 1 - the second node: ");
        list.traverse();

        list.deleteAfterNode(list.getNodeByIndex(2));
        System.out.println("List after delete a node after the firt node: ");
        list.traverse();

        list.deleteByValue(4);
        System.out.println("List after delete by value = 4: ");
        list.traverse();
    }
}