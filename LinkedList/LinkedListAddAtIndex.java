public class LinkedListAddAtIndex {

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex(int idx, int data) {
        Node newNode = new Node(data);
        // Case 1: Adding at the start
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        int i = 0;
        // Traverse to the (idx-1)th position
        while (i < idx - 1 && temp != null) {
            temp = temp.next;
            i++;
        }
        // Case 2: Index out of bounds (greater than the length of the list)
        if (temp == null) {
            System.out.println("Index out of bounds");
            return;
        }
        // Case 3: Adding at the end
        if (temp.next == null) {
            addLast(data);
            return;
        }
        // Inserting at the specified index
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void printLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args){
        LinkedListAddAtIndex ll = new LinkedListAddAtIndex();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(5);
        ll.addAtIndex(3, 4);
        ll.printLinkedList();
    }
}
