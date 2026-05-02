
class HouseRobber2 {

    // public static int robHouses(int[] nums, int[] dp, int idx){
    //     if(idx == 0){
    //         return nums[idx];
    //     }
    //     if(idx < 0){
    //         return 0;
    //     }

    //     if(dp[idx] != -1){
    //         return dp[idx];
    //     }
        
    //     // Rob
    //     int pick = nums[idx] + robHouses(nums, dp, idx-2);

    //     //Do not Rob
    //     int not_pick = 0 + robHouses(nums, dp, idx-1);

    //     return Math.max(pick, not_pick);

    // }

    public static int robHouses(int[] nums){
       
        int prev1 = nums[0];
        int prev2 = 0;
        int curr = Integer.MIN_VALUE;

        for(int i=1; i<nums.length; i++){
            
            //pick 
            int pick;
            if(i-2 >= 0){
                pick = nums[i] + prev2;
            } else{
                pick = nums[i];
            }

            //not pick
            int not_pick = 0 + prev1;

            curr = Math.max(pick, not_pick);

            prev2 = prev1;
            prev1 = curr;
        }

        return curr;

    }

    public static void main(String[] args){
        int[] houses =  {1,2,3,2};
        int n= houses.length;

        int[] houses1 = new int[houses.length-1];
        int[] houses2 = new int[houses.length-1];
        
        for(int i=n-1; i>=1; i--){
            houses1[i-1] = houses[i]; 
        }

        for(int i=0; i<n-1; i++){
            houses2[i] = houses[i]; 
        }


        System.out.println(Math.max(robHouses(houses1), robHouses(houses2)));

    }
}