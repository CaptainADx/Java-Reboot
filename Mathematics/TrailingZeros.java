public class TrailingZeros {
    //Trailing zeros in factorial of  (num)! :    
    // for example : 5! --> 120 ....so number of trailing zeros is 1.

    // f(n) =  n/5 + n/25 + n/125 + ... + n/(pow(5,n))

    public static int countTrailingZerosInFactorial(int num){
        int res = 0;
        for(int i=5; i<=num; i*=5){
            res += num/i;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 15;
        System.out.println(countTrailingZerosInFactorial(num));
    }
}
