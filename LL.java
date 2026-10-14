
public class LL {
    class Node {
        int val;
        Node next ;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);

        n1.next = n2;

        Node temp = n1;

        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        
    }

}
