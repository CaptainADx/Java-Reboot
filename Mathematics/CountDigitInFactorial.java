public class CountDigitInFactorial {
/*
 * 1.   Factorial Growth: The factorial of large numbers grows extremely fast, 
 *      and the number of digits in the factorial of a number can be determined using logarithms.
 * 
 * 2.   We can use the logarithmic property that: log10(a × b) = log10(a) + log10(b). 
 *      This allows us to calculate the logarithm of the factorial of N by summing the 
 *      logarithms of the integers from 1 to N: log10(N!) = log10(1) + log10(2) + log10(3) + ⋯ + log10(N).
 * 
 * 3.   Number of Digits: The number of digits in a number x is given by: 
 *      Number of digits = [log10(x)] + 1. 
 *      Applying this formula to the factorial: 
 *      Number of digits in N! = [log10(N!)] + 1.
 */

    public static int countDigitsInFactorialOfN(int N){
        if(N==0 || N==1){
            return 1;
        }
        double res=0;
        for(int i=2; i<=N; i++){
            res+=Math.log10(i);
        }
        return (int)Math.floor(res)+1;
    }

    public static void main(String[] args) {
        System.out.println(countDigitsInFactorialOfN(5));
    }
}
