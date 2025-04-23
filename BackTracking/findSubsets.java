public class findSubsets {
    public static void findSubset(String s, StringBuilder sb, int i){
        if(i == s.length()){
            if(sb.length() == 0){
                System.out.println("NULL");
            } else{
                System.out.println(sb);
            }
            return;
        }

        //Yes Choice
        findSubset(s, new StringBuilder(sb).append(s.charAt(i)), i+1);
        //No Choice
        findSubset(s, new StringBuilder(sb), i+1);
    }
    

    public static void main(String[] args) {
        String s = "abc";
        int i=0;
        findSubset(s, new StringBuilder(""), i);
    }
}