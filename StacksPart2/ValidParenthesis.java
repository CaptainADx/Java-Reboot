import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                stack.push(ch);
            } else {
                if(!stack.isEmpty()){
                    if((stack.peek() == '(' && ch == ')') || (stack.peek() == '{' && ch == '}') ||(stack.peek() == '[' && ch == ']')){
                        stack.pop();
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        String parenthesis = "[{()}()]{}";
        String parenthesis1= "[{()}()]{";
        System.out.println(isValid(parenthesis));
        System.out.println(isValid(parenthesis1));
    }
}
