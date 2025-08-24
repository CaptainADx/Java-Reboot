public class ValidParenthesis {
    
    public static boolean check(String s, int idx, int count){
        if(count == -1){
            return false;
        }

        if(idx == s.length()){
            return count == 0;
        }

        switch (s.charAt(idx)) {

            case '(' -> {
                return check(s, idx+1, count+1);
            }
            
            case ')' -> {
                return check(s, idx+1, count-1);
            }

            default -> {
                return check(s, idx+1, count+1) || check(s, idx+1, count) || check(s, idx+1, count-1);
            }
        }
    }

    public static boolean checkIfPossible(String s){
        return check(s, 0, 0);
    }
    public static void main(String[] args) {
        String s1 = "((*()";      //False
        String s2 = "(((*)))";    //True
        String s3 = "***())))";  //True
        
        System.out.println(checkIfPossible(s1));
        System.out.println(checkIfPossible(s2));
        System.out.println(checkIfPossible(s3));
    }
}
