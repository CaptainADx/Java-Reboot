public class MyLinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the Linked List
    Node head;

    // Add node at the beginning
    void addFirst(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    // Add node at the end
    void addLast(int data) {

        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Print the linked list
    void display() {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);

        list.display();

        list.addLast(40);
        list.addLast(50);

        list.display();
    }
}
