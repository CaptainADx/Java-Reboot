public class JumpGame_II {
    
    //This code is using Recursive Approach 
    public static int minJumps(int[] nums, int idx, int jumps){
        if(idx >= nums.length-1){
            return jumps;
        }

        int mini = Integer.MAX_VALUE;

        for(int i=1; i<=nums[idx]; i++){
            mini = Math.min(mini, minJumps(nums, idx+i, jumps+1));
        }

        return mini;
    }

    //The below code is better approach with Time --> O(N)
    public static int jump(int[] nums) {
        int l = 0, r = 0, jumps = 0;
        int n = nums.length;

        while(r < n-1){
            int farthest = 0;

            for(int i=l; i<= r; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        
        System.out.println(jump(nums));
    }
}
