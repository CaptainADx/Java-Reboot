public class checkPalindromeLL {
    
    public class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

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

    public void printLinkedList(){
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

        if(head == null || head.next == null){
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



    public static void main(String[] args) {
        checkPalindromeLL ll1 = new checkPalindromeLL();
        ll1.addFirst(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(4);
        ll1.addLast(5);
        ll1.printLinkedList();
        System.out.println("Size of Linked List is -->" + ll1.size);

        if(ll1.checkPalindrome() == false){
            System.out.println("Linked List is not a Palindrome.");
        } else{
            System.out.println("Linked List is a Palindrome");
        }
        System.out.println();
        System.out.println("========================================================================");
        System.out.println();
        checkPalindromeLL ll2 = new checkPalindromeLL();
        ll2.addFirst(1);
        ll2.addLast(1);
        ll2.addLast(2);
        ll2.addLast(1);
        ll2.printLinkedList();
        System.out.println("Size of Linked List is -->" + ll2.size);
        
        if(ll2.checkPalindrome() == false){
            System.out.println("Linked List is not a Palindrome");
        } else{
            System.out.println("Linked List is a Palindrome");
        }
    }
}