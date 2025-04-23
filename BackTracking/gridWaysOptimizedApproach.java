public class gridWaysOptimizedApproach {
    // This way not use the concept of Backtracking
    // Instead of that it uses the concept of permutations
    private static int factorial(int num){
        //We can use recursion to calculate factorial
        //Time complexity = O(n)
        //Space Complexity = O(n)
        // {
        //     if (num == 0 || num == 1) return 1; 
        //     return  num * factorial(num-1);
        // }
        //-------------------------------------------------------------//
        //Or We can use Iterative Approach
        //Time Complexity = O(n)
        //Space Complexity = O(1)
        {
            int fact = 1;
            for(int i=2; i<=num; i++){
                fact*=i;
            }
            return fact;
        }
    }
    private static int gridWays(int rows, int cols){
        int ans = factorial((rows-1) + (cols-1)) / (factorial(rows-1) * factorial(cols-1));

        return ans;
    }
    public static void main(String[] args){
        int n=10, m=29;
        
        System.out.println(gridWays(n,m));
    }
}
