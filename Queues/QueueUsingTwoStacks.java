import java.util.Stack;

public class QueueUsingTwoStacks {

    public static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        void add(int data) {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        int remove() {
            if(s1.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            } else {
                return s1.pop();
            }
        }

        int peek() {
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
