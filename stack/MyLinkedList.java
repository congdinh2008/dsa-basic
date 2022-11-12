public class MyLinkedList {
    private int size;
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
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
    public void addFirst(int value) {
        Node f = head;
        Node newNode = new Node(value);
        if (f == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add a new node to the tail of the list
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    // Add a new node after the preNode
    public void addAfter(Node preNode, int value) {
        if (preNode == null) {
            System.out.println("Previous node is null");
            return;
        }

        Node newNode = new Node(value);

        newNode.next = preNode.next;

        preNode.next = newNode;
        size++;
    }
    // #endregion

    // #region Get - Search Methods

    // Get the head value
    public int getHead() {
        return head.data;
    }

    // Get the tail value
    public int getTail() {
        Node f = head;
        while (f.next != null) {
            f = f.next;
        }
        return f.data;
    }

    // Get a node by index
    public Node getNodeByIndex(int index) {
        Node x = head;
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
            Node x = head;

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
            Node x = head;
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
    public void deleteAfterNode(Node prevNode) {
        if (prevNode.next == null) {
            System.out.println("Element after the node not found");
        } else {
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    // Delete all node by value
    public void deleteByValue(int value) {
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            Node x = head;
            int i = 0;
            while (x != null) {
                if (x.data == value) {
                    deleteAtIndex(i);
                    i--;
                }
                i++;
                x = x.next;
            }
        }
    }

    // #endregion

    // #region Update Methods

    // Update a node by index
    public void updateByIndex(int index, int value) {
        Node needUpdate = getNodeByIndex(index);
        if (needUpdate != null) {
            needUpdate.data = value;
        } else {
            throw new NullPointerException("Element not found");
        }
    }

    // #endregion

    public void traverse() {
        Node x = head;
        while (x != null) {
            System.out.println(x.data);
            x = x.next;
        }
    }
    // #endregion
}
