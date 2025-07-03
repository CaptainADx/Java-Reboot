//This Question is from LEETCODE --> Problem No. - 3304
public class StringGame {
    //We need to return the Kth character after performing operations on initial string "a" 
    public static char stringGameNaiveApproach(int k){

    // In this approach we are using String Data Structure.
        String s = "a";
        int n = k;
        while(n-- > 0){
            String newStr="";
            for(int i=0; i<s.length(); i++){
                char c = (char)(1+s.charAt(i));
                // System.out.println(c);
                newStr += c;
            }
            s += newStr;

            if(s.length() >= k){
                break;
            }
        }
        System.out.println(s);
        return s.charAt(k-1);
    }

    public static char stringGameBetterApproach(int k) {
        //Here we are using StringBuilder DataStructure to prevent the creation of redundant strings in memory.
        StringBuilder s = new StringBuilder("a");
        int n = k;

        while (n-- > 0) {
            StringBuilder newStr = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = (char)(((s.charAt(i) - 'a' + 1) % 26) + 'a');
                newStr.append(c);
            }

            s.append(newStr);

            if (s.length() >= k) {
                break;
            }
        }

        return s.charAt(k - 1);
    }

    public static char stringGameOptimizedApproach(int k) {
        //This is the optimized approach in which time complexity is O(k).
        
        if (k == 1) return 'a';

        // Find the smallest power of 2 >= k
        int len = 1;
        while (len * 2 < k) {
            len *= 2;
        }

        if (k <= len) {
            return stringGameOptimizedApproach(k);
        } else {
            char ch = stringGameOptimizedApproach(k - len);
            // Shift it by 1
            return (char)(((ch - 'a' + 1) % 26) + 'a');
        }
    }


    public static void main(String[] args){
        char c = stringGameOptimizedApproach(5);
        System.out.println(c);
    }
}
