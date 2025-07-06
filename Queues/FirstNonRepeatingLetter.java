import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingLetter {
    
    public static void findFirstNonRepeatingLetter(String str){
        Queue<Character> q = new LinkedList<>();
        if(str.length() == 0){
            System.out.println("Empty Character Stream Passed");
            return;
        }
        if(str.length() == 1){
            System.out.println(str);
            return;
        }
        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        for(int i=0; i<str.length(); i++){
            q.add(str.charAt(i));
            freq[str.charAt(i) - 'a']++;
            while(!q.isEmpty()){
                if(freq[q.peek()-'a'] > 1){
                    q.remove();
                } else{
                    break;
                }
            }
        }
        if(q.isEmpty()){
            System.out.println("No Non-Repeating Element is Present");
        } else{
            System.out.println("First Non-Repeating Letter is --> " + q.peek());
        }
    }
    public static void main(String[] args) {
        String s = "aabccxbc";
        findFirstNonRepeatingLetter(s);

    }
}
