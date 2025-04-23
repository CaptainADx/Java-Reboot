
public class DetectCycleInLL {
    
    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

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

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        
    }

    public static void printLinkedList(){
        if(head == null){
            System.out.println("Linked List is Empty ! ");
            return;
        }
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    //Using Slow-Fast Pointer Approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;  //increment by 1
            fast = fast.next.next; //increment by 2
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){   //This case is for the Linked List with 0 element or 1 element
            return true;
        }

        //Step-1 : Find Mid
        Node midNode = findMid(head);

        //Step-2 : Reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        //Check if all element of right is in the Left too or not
        while(right != null){
            if(right.data != left.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static boolean detectCycle(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;
        //PRINT STATEMENT SHOULD NOT BE USED SINCE CYCLE IS PRESENT IN THE ABOVE LINKED LIST
        // printLinkedList();           //In this case a cycle in LL is present so it will print infinite times...
        
        System.out.println(detectCycle());

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = null;
        printLinkedList();
        
        System.out.println(detectCycle());
    }
}
