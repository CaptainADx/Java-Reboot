import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static ArrayList<String> generate(int n){
        ArrayList<String> arr = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add("1");

        for(int i=0; i<n; i++){
            String current = queue.poll();
            arr.add(current);
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
        return arr;
    }  
    
    public static void main(String[] args) {
        int n = 7;
        System.out.println(generate(n));

    }
}
