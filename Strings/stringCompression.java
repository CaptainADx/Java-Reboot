
public class stringCompression {
    
    public static String compress(String str){
        StringBuilder newStr = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count =1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if(count > 1){
                newStr.append(count.toString());
            }
        }
        return newStr.toString();
    }
    public static void main(String[] args) {
        String input = "aaabbccccddd";

        long startTime = System.nanoTime();
        System.out.println(compress(input));
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime)/1_000_000_000.0;
        System.out.println(executionTime);
    }
}
