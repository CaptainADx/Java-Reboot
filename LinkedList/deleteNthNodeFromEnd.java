public class deleteNthNodeFromEnd {
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

    public void deleteNodeFromEnd(int idx){
        Node temp = head;
        int size=0;
        int i=1;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        System.out.println("Size of LinkedList --> " + size);

        if(idx == size){
            head = head.next;
            return;
        }

        int idxToFind = size-idx;
        Node prev = head;
        while(i < idxToFind){
            i++;
            prev = prev.next;
            
        }
        prev.next = prev.next.next;
    }
    
    public static void main(String[] args) {
        deleteNthNodeFromEnd ll = new deleteNthNodeFromEnd();
        // ll.printLinkedList();
        ll.addFirst(2);
        // ll.printLinkedList();
        ll.addFirst(1);
        // ll.printLinkedList();
        ll.addLast(3);
        // ll.printLinkedList();
        ll.addLast(4);
        ll.printLinkedList();
        
        // //Reversing the Linked List
        // ll.reverse();
        // ll.printLinkedList();
        ll.deleteNodeFromEnd(3);
        ll.printLinkedList();

    }
}