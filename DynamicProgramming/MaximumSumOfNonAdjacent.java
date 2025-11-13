
class MaximumSumOfNonAdjacent{

    //This Problem is Also Called House Robber on leetcode - 198

    /* 
    
    <----------------- Recursive Approach ---------------------->
    private static int robHouses(int[] nums, int idx){
        if(idx == 0){
            return nums[idx];
        }
        if(idx < 0){
            return 0;
        }

        //Rob House
        int pick = nums[idx] + robHouses(nums, idx-2);

        //Not Rob House
        int not_pick = 0 + robHouses(nums, idx-1);

        return Math.max(pick, not_pick);
    }
    
    */

    /*
    // <------------------ Memoization ---------------------->
    private static int robHouses(int[] nums, int[] dp, int idx){
        if(idx < 0){
            return 0;
        }
        if(idx == 0){
            return nums[idx];
        }

        if(dp[idx] != -1) return dp[idx];

        //Pick
        int pick = nums[idx] + robHouses(nums, dp, idx-2);

        //Not-Pick
        int not_pick = 0 + robHouses(nums, dp, idx-1);

        return dp[idx] = Math.max(pick, not_pick);
    }
    */

    /*
    //<----------------------- Tabulation Approach ----------------------->

    private static int robHouses(int[] nums, int[] dp){
        int neg = 0;
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++){

            //pick case
            int pick;

            if(i-2 >= 0){
                pick = nums[i] + dp[i-2];
            } else{
                pick = nums[i] + neg;
            }
            
            //Not-Pick case
            int not_pick = 0 + dp[i-1];

            dp[i] = Math.max(pick, not_pick);
        }

        return dp[dp.length-1];


    }

    */

    //<----------------------- Tabulation Approach Space Optimized ----------------------->

    private static int robHouses(int[] nums){
        int prev2 = 0;
        int prev1 = nums[0];
        int curr = Integer.MIN_VALUE;

        for(int i=1; i<nums.length; i++){

            //pick case
            int pick;

            if(i-2 >= 0){
                pick = nums[i] + prev2;
            } else{
                pick = nums[i] ;
            }
            
            //Not-Pick case
            int not_pick = 0 + prev1;

            curr  = Math.max(pick, not_pick);

            prev2 = prev1;
            prev1 = curr;
        }

        return curr;


    }


    public static void main(String[] args) {
        int[] houses =  {2,7,9,3,1};


        System.out.print("Maximum Money The Robber can rob is --> " + robHouses(houses));
    }
}