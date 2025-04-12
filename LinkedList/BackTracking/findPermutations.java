public class findPermutations {
    
    public static void findAllPermutations(String s, String ans){
        if(s.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            String newStr = s.substring(0, i) + s.substring(i+1);
            findAllPermutations(newStr, ans+currChar);
        }
    }

    public static void main(String[] args){
        String s = "abc";
        findAllPermutations(s, "");
    }
}
