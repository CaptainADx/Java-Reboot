public class mergeSortOnLinkedList {
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
    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;

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

    public static Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public static Node mergeSort(Node head){
        //Base case
        if(head == null || head.next == null){
            return head;
        }

        //Find mid
        Node mid = findMid(head);
        
        //left & right merge sort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }


    public static void main(String[] args) {
        mergeSortOnLinkedList ll = new mergeSortOnLinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        printLinkedList();

        head = mergeSort(head);
        printLinkedList();
    }
}
