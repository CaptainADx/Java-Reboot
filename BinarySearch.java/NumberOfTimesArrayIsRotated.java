public class NumberOfTimesArrayIsRotated {
    
    public static int findNumberOfTimesArrayIsRotated(int[] nums, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;

            while(low < high && (nums[low] == nums[mid] && nums[mid] == nums[high])){
                low++;
                high--;
            }

            if(mid > 0 && nums[mid] < nums[mid-1]){
                return mid;
            }
            //if Left part is sorted
            if(nums[low] <= nums[mid]){
                low = mid+1;
            } 
            //if Right part is sorted
            else{
                high = mid-1;
            }
        }
        
        return 0;
    }
    public static void main(String[] args) {
        // int[] nums = {4, 5, 1, 2, 3, 4, 4, 4};
        int[] nums = {1, 3, 5};
        int ans = findNumberOfTimesArrayIsRotated(nums, 0, nums.length-1);
        int numberOfTimesArrayIsRotated;
        if(ans != 0){
            numberOfTimesArrayIsRotated = nums.length - ans; 
        } else{
            numberOfTimesArrayIsRotated = ans;
        }
        System.out.println("Number of Times Array Is Rotated --> " + numberOfTimesArrayIsRotated);
    }
}
