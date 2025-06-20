import java.util.Arrays;
public class FibonacciNumber {

    //By MEMOIZATION TECHNIQUE
    public static int calculateFiboBottomUpApproach(int n, int[] dp){
        if(n==0 || n==1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = calculateFiboBottomUpApproach(n-1, dp) + calculateFiboBottomUpApproach(n-2, dp);
        return dp[n];
    }

    //BY ITERATIVE TECHNIQUE
    public static int calculateFiboTopDownApproach(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args){
        int n = 10;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.print("Approach using Memoization --> ");
        System.out.println(calculateFiboBottomUpApproach(n, dp));
        System.out.print("Approach using Iteration --> ");
        System.out.println(calculateFiboTopDownApproach(n));
    }
}
