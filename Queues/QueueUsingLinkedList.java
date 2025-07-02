public class QueueUsingLinkedList {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue{
        Node head;
        Node tail;

        public Queue() {
            head = null;
            tail = null;
        }

        boolean isEmpty(){
            return (head==null && tail == null);
        }

        void add(int data){

            Node newNode = new Node(data);

            if(isEmpty()){
               head = tail =  newNode;
               return;
            }
            tail.next = newNode;
            tail = newNode;
            
        }

        int remove(){
            if(isEmpty()){
                System.out.println("Linked List is Empty");
                return -1;
            }
            
            int deleted = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }
            return deleted;
        }

        int peek(){
            if(isEmpty()){
                System.out.println("Linked List is Empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.remove();
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
