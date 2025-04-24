public class ZigZagLinkedList {
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

    public static void removeCycle(){
        //Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }

        //Find the Node from where cycle starts
        slow = head;
        Node prev = null;

        //Special case if the cycle starts from head
        if (slow == fast && fast!=null) {
            while (fast != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }

        //Continue with the normal logic if cycle starts from anywhere other than head
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            if(fast != null){       //**** This condition is added if the FAST is already at null then Null.next will not make sense
                fast = fast.next;
            }
        }

        //Remove cycle
        if (prev != null) {        //**** This condition is added if the PREV is already at null then Null.next will not make sense
            prev.next = null;
        }
    }

    public Node zigzagOptimum(Node head){
        //Find Mid
        Node midNode = findMid(head);

        //reverse second half

        Node prev = null;
        Node curr = midNode.next;
        midNode.next = null;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;

        //Arrange in alternate fashion
        Node nextLeft, nextRight;

        while(left!= null && right != null){
            nextLeft = left.next;
            left.next = right;

            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
        return head;
    }

    public static void main(String[] args) {
        ZigZagLinkedList ll = new ZigZagLinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        printLinkedList();
        ll.zigzagOptimum(head);
        printLinkedList();
    }


}
