public class BitFlipsToMakeEqual {
    
    public static int countSetBits(int n){
        int setBits = 0;
        while(n>0){
            n&=(n-1);
            setBits++;
        }
        return setBits;
    }
    public static int countBitsFlip(int a, int b) {
        // code here
        int xor = a^b;
        return countSetBits(xor);
    }

    public static void main(String[] args) {
        int a =10, b =16;
        System.out.println(countBitsFlip(a, b));
    }
}
