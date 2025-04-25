import java.util.ArrayList;

public class StackBasics {
    public static class Stack {

        ArrayList<Integer> list = new ArrayList<>();

        //Checks that is the stack is empty or not
        public boolean isEmpty(){
            // return list.size()==0;
            return list.isEmpty(); //isEmpty() is inbuilt method for arrayList....
        }

        //Push Operation
        public void push(int data){
            list.add(data);
        }

        //Pop Operation
        public int pop(){
            int top;
            if(!list.isEmpty()){
                top = list.get(list.size()-1);
                list.remove(list.size()-1);
            } else {
                return -1;
            }
            return top;
        }

        //Peek Operation
        public int peek(){
            return list.get(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.isEmpty();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
