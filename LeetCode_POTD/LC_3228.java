public class LC_3228 {
    public static int maxOperations(String s) {
        int n = s.length();
        int count1 = 0;
        int ways = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                count1++;
            }
            else{
                if(i>0 && s.charAt(i-1) != '0'){ 
                    ways += count1;
                }
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        String s = "1001101";
        System.out.print(maxOperations(s));
    }

}
