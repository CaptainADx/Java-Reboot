public class Solution {
    
    public static class ListNode{
        int data;
        ListNode next;
        public ListNode(int _data) {
            this.data = _data;
            this.next = null;
        }
    }

    public static ListNode head;

    public void addNode(int data){
        
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public int deleteNode(int _data){
        ListNode temp = head;
        if(temp == null) {
            System.out.println("LinkedList is Empty");
            return -1;
        } else if(temp.data == _data){
            System.out.println("Node deleted = " + temp.data);
            head = temp.next;
            return 0;
        } else{
            while(temp.next.data != _data){
                temp = temp.next;
            }
            int deletedValue = temp.next.data;
            temp.next = temp.next.next;
            System.out.println("Node deleted Successfully ! ! !");
            return deletedValue;
        }
        
    }

    public static void main(String[] args) {
        Solution ll = new Solution();
        ll.addNode( 0);
        ll.addNode(1);
        ll.addNode(2);
        ll.addNode(3);
        ll.addNode(4);

        ListNode temp = head;

        ll.deleteNode(3);

        while(temp != null){
            if(temp.next == null){
                System.out.println(temp.data + " --> NULL");
            }else{
                System.out.print(temp.data + " --> ");
            }
            temp = temp.next;
        }

    }

    
}
