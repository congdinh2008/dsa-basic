/**
 * LinkedListTest
 */
public class LinkedListTest {

    public static void main(String[] args) {
        MyCustomLinkedList list = new MyCustomLinkedList();

        System.out.println("Test add 10 node at first:");
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(5);
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(5);
        list.addFirst(5);

        System.out.println("List after add 3 value at first: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());
        
        System.out.println("Test add 2 node at last:");
        list.addLast(0);
        list.addLast(11);
        
        System.out.println("List after add 2 value at last: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());
        
        System.out.println("Value of head: ");
        System.out.println(list.getHead());
        
        System.out.println("Value of tail: ");
        System.out.println(list.getTail());
        
        System.out.println("Test add a node with index = 1 and value = 17: ");
        list.addAfter(list.getNodeByIndex(1), 17);
        System.out.println("List after add 17 after second node: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());
        
        System.out.println("Test delete the first node: ");
        list.deleteFirst();
        System.out.println("List after delete the first node: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());
        
        System.out.println("Test delete the last node: ");
        list.deleteLast();
        System.out.println("List after delete the last node: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());
        
        System.out.println("Test delete a node at index = 1: ");
        list.deleteAtIndex(1);
        System.out.println("List after delete a node with index = 1 - the second node: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());
        
        System.out.println("Test Delete a node after node with index = 2:");
        list.deleteAfterNode(list.getNodeByIndex(2));
        System.out.println("List after delete a node after the third node: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());
        
        System.out.println("Test Delete by value = 5:");
        list.deleteByValue(5);
        System.out.println("List after delete by value = 5: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());

        System.out.println("Test update by index:");
        list.updateByIndex(1, 49);
        System.out.println("List after update node second by value = 49: ");
        list.traverse();
        System.out.println("Number of elements: " + list.size());
    }
}