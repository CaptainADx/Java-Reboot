public class Solution {
    
    public static void changeA(Integer a){
        a = 20;
    }

    public static void main(String[] args) {
        Integer a = 10;

        changeA(a);

        System.out.println(a);
    }
}
