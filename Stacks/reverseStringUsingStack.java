import java.util.*;

public class reverseStringUsingStack {
    public static class CustomStack{
        ArrayList<Character> list = new ArrayList<>();

        //Is Empty Function
        public boolean isEmpty(){
            return list.isEmpty();
        }

        //Push Function
        public void push(char c){
            list.add(c);
        }

        //Pop Function
        public char pop(){
            if(!list.isEmpty()){
                char top = list.get(list.size()-1);
                list.remove(list.size()-1);
                return top;
            }
            return '\0';
        }

        //Peek Function
        public char peek(){
            return list.get(list.size()-1);
        }
    }

    public static String reverseString(String s){
        CustomStack stack = new CustomStack();
        int i = 0;
        while(i < s.length()){
            stack.push(s.charAt(i));
            i++;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        
        String s = "Abhijeet";
        
        System.out.println(reverseString(s));
    }
}
