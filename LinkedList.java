public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null) {
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

    public void printLinkedList(){
        if(head  == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.printLinkedList();
        ll.addFirst(2);
        ll.printLinkedList();
        ll.addFirst(1);
        ll.printLinkedList();
        ll.addLast(3);
        ll.printLinkedList();
        ll.addLast(4);
        ll.printLinkedList();
        
    }
}


 