public class MyLinkedList<E> {
    private int size;
    private Node<E> head;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    // #region getters and setters

    public int size() {
        return size;
    }

    // #endregion

    // #region Methods

    // #region Add Methods

    // Add a new node to the head of the list
    public void addFirst(E value) {
        Node<E> f = head;
        Node<E> newNode = new Node<E>(value);
        if (f == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add a new node to the tail of the list
    public void addLast(E value) {
        Node<E> newNode = new Node<E>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    // Add a new node after the preNode
    public void addAfter(Node<E> preNode, E value) {
        if (preNode == null) {
            System.out.println("Previous node is null");
            return;
        }

        Node<E> newNode = new Node<E>(value);

        newNode.next = preNode.next;

        preNode.next = newNode;
        size++;
    }
    // #endregion

    // #region Get - Search Methods

    // Get the head value
    public E getHead() {
        return head.data;
    }

    // Get the tail value
    public E getTail() {
        Node<E> f = head;
        while (f.next != null) {
            f = f.next;
        }
        return f.data;
    }

    // Get a node by index
    public Node<E> getNodeByIndex(int index) {
        Node<E> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    // #endregion

    // #region Delete Methods

    // Delete first node
    public void deleteFirst() {
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
        size--;
    }

    // Delete last node
    public void deleteLast() {
        if (head.next == null) {
            head = null;
        } else {
            Node<E> x = head;

            while (x.next.next != null) {
                x = x.next;
            }

            x.next = null;
        }
        size--;
    }

    // Delete node by index
    public void deleteAtIndex(int index) {
        if (size <= index) {
            System.out.println("Element at the index not found");
        } else {
            Node<E> x = head;
            if (index == 0) {
                head = head.next;
                x = head;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    x = x.next;
                }

                x.next = x.next.next;
            }
        }
        size--;
    }

    // Delete a node after another node
    public void deleteAfterNode(Node<E> prevNode) {
        if (prevNode.next == null) {
            System.out.println("Element after the node not found");
        } else {
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    // Delete all node by value
    // public void deleteByValue(String studentName) {
    //     if (size == 0) {
    //         System.out.println("List is empty");
    //     } else {
    //         Node<E> x = head;
    //         int i = 0;
    //         while (x != null) {
    //             if (x.data.getName().equals(studentName)) {
    //                 deleteAtIndex(i);
    //                 i--;
    //             }
    //             i++;
    //             x = x.next;
    //         }
    //     }
    // }

    // #endregion

    // #region Update Methods

    // Update a node by index
    public void updateByIndex(int index, E value) {
        Node<E> needUpdate = getNodeByIndex(index);
        if (needUpdate != null) {
            needUpdate.data = value;
        } else {
            throw new NullPointerException("Element not found");
        }
    }

    // #endregion

    public void traverse() {
        Node<E> x = head;
        while (x != null) {
            System.out.println(x.data.toString());;
            x = x.next;
        }
    }
    // #endregion
}
