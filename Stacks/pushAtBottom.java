import java.util.Stack;

public class pushAtBottom {
    public static void pushAtBottomOfStack(Stack<Integer> stack, int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottomOfStack(stack, data);
        stack.push(top);
    }
    
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottomOfStack(s, 4);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}