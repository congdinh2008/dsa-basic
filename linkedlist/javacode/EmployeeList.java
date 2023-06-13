import java.time.LocalDate;

public class EmployeeList {
    private int size;
    private Node<Employee> head;

    public EmployeeList(){
        
    }

    public EmployeeList(Employee[] employees){
        for (Employee employee : employees) {
            addFirst(employee);
        }
    }

    private static class Node<Employee> {
        Employee data;
        Node<Employee> next;

        Node(Employee data) {
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
    public void addFirst(Employee value) {
        Node<Employee> f = head;
        Node<Employee> newNode = new Node<Employee>(value);
        if (f == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add a new node to the tail of the list
    public void addLast(Employee value) {
        Node<Employee> newNode = new Node<Employee>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<Employee> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    // Add a new node after the preNode
    public void addAfter(Node<Employee> preNode, Employee value) {
        if (preNode == null) {
            System.out.println("Previous node is null");
            return;
        }

        Node<Employee> newNode = new Node<Employee>(value);

        newNode.next = preNode.next;

        preNode.next = newNode;
        size++;
    }

    public void addByIndex(Node<Employee> preNode, Employee value, int index) {

        Node<Employee> prevNode = getNodeByIndex(index - 1);
        addAfter(preNode, value);
        size++;
    }
    // #endregion

    // #region Get - Search Methods

    // Get the head value
    public Employee getHead() {
        return head.data;
    }

    // Get the tail value
    public Employee getTail() {
        Node<Employee> f = head;
        while (f.next != null) {
            f = f.next;
        }
        return f.data;
    }

    // Get a node by index
    public Node<Employee> getNodeByIndex(int index) {
        Node<Employee> x = head;
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
            Node<Employee> x = head;

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
            Node<Employee> x = head;
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
    public void deleteAfterNode(Node<Employee> prevNode) {
        if (prevNode.next == null) {
            System.out.println("Element after the node not found");
        } else {
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    // Delete all node by value

    public void deleteByName(String name) {
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            Node<Employee> x = head;
            int i = 0;
            while (x != null) {
                if (x.data.getFullName().equals(name)) {
                    deleteAtIndex(i);
                    i--;
                }
                i++;
                x = x.next;
            }
        }
    }

    public EmployeeList searchByName(String name) {
        EmployeeList result = new EmployeeList();
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            Node<Employee> x = head;
            while (x != null) {
                if (x.data.getFullName().equalsIgnoreCase(name)) {
                    result.addLast(x.data);
                }
                x = x.next;
            }
        }

        return result;
    }
    // #endregion

    // #region Update Methods

    // Update a node by index
    public void updateByIndex(int index, Employee value) {
        Node<Employee> needUpdate = getNodeByIndex(index);
        if (needUpdate != null) {
            needUpdate.data = value;
        } else {
            throw new NullPointerException("Element not found");
        }
    }

    // #endregion

    public void traverse() {
        Node<Employee> x = head;
        while (x != null) {
            System.out.println(x.data.toString());
            ;
            x = x.next;
        }
    }
    // #endregion
}
