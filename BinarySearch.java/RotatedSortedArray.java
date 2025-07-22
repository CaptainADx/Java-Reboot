public class RotatedSortedArray {
    public static int searchInRotatedSortedArray(int[] nums, int target) {
        int low = 0, high = nums.length-1; 
        while(low <= high){
            int mid = low + (high-low)/2;
            //If element is present in the mid return Mid
            if(nums[mid] == target){
                return mid;
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
        return -1;   //If the element does not exists in the nums array
    }

    public static void main(String[] args) {
        int[] nums= {5, 6, 7, 1, 2, 3, 4};
        int target = 7;
        System.out.println(searchInRotatedSortedArray(nums, target));
    }
}

