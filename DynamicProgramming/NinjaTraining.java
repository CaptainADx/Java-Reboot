import java.util.Arrays;

public class NinjaTraining {

    /* 
    // <-------------------- RECURSIVE APPROACH -------------------->
    public static int f(int day, int last, int[][] points){
        
        if(day == 0){
            int maxi = 0;
            for(int task=0; task<3; task++){
                if(task != last){
                    maxi = Math.max(maxi, points[day][task]);
                }
            }
            return maxi;
        }
        
        int maxi = 0;

        for(int task=0; task<3; task++){
            if(task != last){
                maxi = Math.max(maxi, points[day][task] + f(day-1, task, points));
            }
        }
        return maxi;

    }

    */

    // <------------------ MEMOIZATION APPROACH ------------------>
    public static int f(int day, int last, int[][] points , int[][] dp){
        
        if(day == 0){
            int maxi = 0;
            for(int task=0; task<3; task++){
                if(task != last){
                    maxi = Math.max(maxi, points[day][task]);
                }
            }
            return maxi;
        }

        if(dp[day][last] != -1) return dp[day][last];
        
        int maxi = 0;

        for(int task=0; task<3; task++){
            if(task != last){
                maxi = Math.max(maxi, points[day][task] + f(day-1, task, points, dp));
            }
        }
        return dp[day][last] = maxi;

    }



    public static int maxPoints(int[][] points, int n){
        int[][] dp = new int[n][4];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return f(n-1, 3, points, dp);
    }

    public static void main(String[] args) {

        // ---------- 7 STATIC TEST CASES ----------
        int[][][] tests = {

            // Test 1
            {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
            },

            // Test 2
            {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
            },

            // Test 3
            {
                {5, 4, 3},
                {2, 1, 7},
                {9, 8, 6},
                {3, 4, 5}
            },

            // Test 4
            {
                {10, 1, 10},
                {1, 50, 1},
                {10, 1, 10}
            },

            // Test 5
            {
                {7, 8, 9}
            },

            // Test 6
            {
                {100, 1, 1},
                {1, 100, 1},
                {1, 1, 100}
            },

            // Test 7
            {
                {3, 2, 7},
                {5, 1, 8},
                {9, 6, 3},
                {4, 2, 1},
                {7, 8, 5}
            }
        };

        // ---------- RUNNING ALL TEST CASES ----------
        for (int i = 0; i < tests.length; i++) {
            int[][] points = tests[i];
            int n = points.length;

            int result = maxPoints(points, n);
            System.out.println("Test " + (i + 1) + ": " + result);
        }
    }

}
