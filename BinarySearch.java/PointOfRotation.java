public class PointOfRotation {
    
    public static int findPointOfRotationRecursive(int[] arr, int si, int ei){
        if(si>=ei){
            return si;
        }
        int mid = si + (ei-si)/2;
        if(arr[mid] >= arr[ei]){
            return findPointOfRotationRecursive(arr, mid+1, ei);
        } else {
            return findPointOfRotationRecursive(arr, si, mid);
        }
    }

    
    public static int findPointOfRotationIteative(int[] nums, int si, int ei){
        
        int low = 0, high = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            //If Mid is point to the exact point of Rotation
            if(mid > 0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            }

            // If Array is already sorted... 
            // This case also happens when low crosses or point to the "Point of Rotation"
            if(nums[low] <= nums[high]){
                return Math.min(ans, nums[low]);
            }

            //If Left-Half is sorted
            if(nums[mid] >= nums[low]){
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            } 
            //If right-Half is sorted
            else{
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }

        //Return Answer in the end
        return ans;

    }
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        int idx = findPointOfRotationIteative(arr, 0, arr.length-1);
        System.out.println(idx);
    }
}
