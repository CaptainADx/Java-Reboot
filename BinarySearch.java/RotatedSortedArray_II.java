public class RotatedSortedArray_II {
    // This is a variation of Rotated Sorted Array - I...
    // This time array will contain duplicate elements also...
    // since the rest of the code works fine, we just need to add the below edge case check
    // Also this time we will return Boolean value instead of index... Its because we have duplicate element
    // and we dont know among the duplicates which one's index we need to return.
    /* 
     if(nums[low] == nums[mid] && nums[mid] == nums[high]){
        low++;
        high--;
        continue;
    }
    */
    


    public static boolean searchInRotatedSortedArray(int[] nums, int target) {
        int low = 0, high = nums.length-1; 
        while(low <= high){
            int mid = low + (high-low)/2;
            //If element is present in the mid return Mid
            if(nums[mid] == target){
                return true;
            }

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }

            //Identify wether Left Part is sorted or Right part is sorted ?

            //If Left Part is Sorted
            if(nums[mid] >= nums[low]){
                //Now Identify which part to eleminate Right or Left by comparing the values
                
                if(nums[low] <= target && nums[mid] >= target){   //Eleminate right
                    high = mid-1;
                } else{             //Eleminate Left
                    low = mid+1;
                }   
            } 
            else {    //Right Part is Sorted

                //Now Identify Again Which Part to be eleminated -- Left or Right ?
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid+1;   //Eleminate left
                } else{
                    high = mid-1;
                }

            }
        }
        return false;   //If the element does not exists in the nums array
    }

    public static void main(String[] args) {
        int[] nums= {3, 3, 4, 5, 6, 7, 1, 2, 3, 3, 3};
        int target = 4;
        System.out.println(searchInRotatedSortedArray(nums, target));
    }

}
