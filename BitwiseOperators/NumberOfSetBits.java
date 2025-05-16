public class NumberOfSetBits {
    // To Solve this Problem we are using BRIAN KARNIGHAN'S ALGORITHM

    public static int findNumberOfSetBits(int num){
        int res = 0;
        while(num > 0){
            res++;
            num &= (num-1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(findNumberOfSetBits(n));
    }
}
