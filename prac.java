

public class prac {
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
    public static int size;

    //---------------ADD FIRST---------------------
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //--------------ADD LAST-------------------------
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }


    //------------------Code to Print the linked list--------------------------
    public void printLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    //----------------------REMOVE FIRST----------------------------
    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1){
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }


    //----------------------Main Function--------------------------
    public static void main(String[] args){
        prac ll = new prac();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.printLinkedList();
        System.out.println("Size of Linked List is --> " + size);
        // ll.removeFirst();
        // ll.printLinkedList();
    }
}
