public class reverseLinkedList {
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

    public int linearSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    //Method to reverse the Linked List.
    public void reverse(){
        Node prev = null; 
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    
    public static void main(String[] args) {
        reverseLinkedList ll = new reverseLinkedList();
        // ll.printLinkedList();
        ll.addFirst(2);
        // ll.printLinkedList();
        ll.addFirst(1);
        // ll.printLinkedList();
        ll.addLast(3);
        // ll.printLinkedList();
        ll.addLast(4);
        ll.printLinkedList();
        
        //Reversing the Linked List
        ll.reverse();
        ll.printLinkedList();

    }
}
