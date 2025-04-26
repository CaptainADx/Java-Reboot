public class StackUsingLinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack{
        public static Node head = null;
        //Is empty function
        public boolean isEmpty(){
            return head == null;
        }

        //Push Operation
        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        //Pop Operation
        public int pop(){
            int top = -1;
            if(!isEmpty()){
                top = head.data;
                head = head.next;
            } 
            return top;
        }

        //Peek Operation
        public int peek(){
            int top = -1;
            if(!isEmpty()){
                return head.data;
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }

    }
}
