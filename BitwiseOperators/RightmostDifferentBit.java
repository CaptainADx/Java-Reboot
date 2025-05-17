public class RightmostDifferentBit {
    public static int findRightmostDifferentBit(int num1, int num2){
        int xor = num1^num2;
        int rightmostBit = xor & ((~xor)+1);  //this expression means -->  (xor & (-xor))
        int pos = 0;
        while(rightmostBit != 0){
            rightmostBit>>=1;
            pos++;
        }
        return pos;
    }

    public static void main(String[] args) {
        int m = 52, n=4;
        System.out.println(findRightmostDifferentBit(m, n));
    }
}
