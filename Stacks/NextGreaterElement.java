import java.util.*;
public class NextGreaterElement {

    public static int[] findNextGreater(int[] arr, int[] sol){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        sol[n-1] = -1;
        stack.push(arr[n - 1]);
        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                sol[i] = -1;
            } else {
                sol[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return sol;

    }
    
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int[] sol = new int[arr.length];

        findNextGreater(arr, sol);

        for(int ele : sol){
            System.out.print(ele + " ");
        }
    }
}
