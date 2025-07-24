public class SingleElementInSortedArray {
    
    public static int findSingleElement(int[] nums, int low, int high){

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }

            //Identify if we are on left half or right half....
            //Now Identify Which part to eleminate

            //If we are on LEFT half of Single element the Index of Couple of Element will have (even, odd)
            if(((mid%2 == 1) && nums[mid] == nums[mid-1]) || (mid%2 == 0 && nums[mid] == nums[mid+1])){
                low = mid+1;
            }

            //If we are on RIGHT half of Single element the Index of Couple of Element will have (odd, even)
            else if(((mid%2 == 0) &&  nums[mid] == nums[mid-1]) || (mid%2 == 1 && nums[mid] == nums[mid+1])){
                high = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        int n=nums.length;
        if(n==1){
            System.out.println(nums[0]);
        } 
        else if(nums[0] != nums[1]){
            System.out.println(nums[0]);
        }
        else if(nums[n-1] != nums[n-2]){
            System.out.println(nums[n-1]);
        }
        else{
            System.out.println(findSingleElement(nums, 1, n-2));
        }
    }
}
