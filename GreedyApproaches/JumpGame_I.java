public class JumpGame_I {
    
    public static boolean canJump(int[] nums) {
        int maxIdx = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(i > maxIdx){
                return false;
            }
            maxIdx = Math.max(maxIdx, i+nums[i]);
            if(maxIdx > n){
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,0,4};    //Output : False
        int[] nums1 = {2,3,1,1,4};   //Output : True

        System.out.println(canJump(nums));
        System.out.println(canJump(nums1));

    }
}
