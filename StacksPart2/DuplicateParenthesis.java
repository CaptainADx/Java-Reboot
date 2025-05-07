import java.util.Stack;
public class DuplicateParenthesis {

    
    public static boolean checkDuplicateParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int count = 0;
            if((ch != ')') || (ch != '}') || (ch != ']')){
                stack.push(ch);
            }
            while(!stack.isEmpty()){
                char top = stack.peek();
                if((ch ==')' && top =='(') || (ch =='}' && top =='{') || (ch ==']' && top =='[')){
                    if(count != 0){
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.pop();
                    count++;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "[{(a)}]";
        System.out.println(checkDuplicateParenthesis(s));
    }

}
