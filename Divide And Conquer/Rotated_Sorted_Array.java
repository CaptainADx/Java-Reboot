public class Rotated_Sorted_Array {
    public static int search(int[] arr,int target,int si, int ei){
        //INVALID CONDITION
        if(si > ei){
            return -1;
        }

        int mid = si + (ei-si) /2;
        
        // BEST case
        if(arr[mid] == target){
            return mid;
        }
        
        //CASE 1: MID IS ON LEFT LINE
        if(arr[si] <= arr[mid]){
            //case a: left side of mid of First line
            if(arr[si]<=target && arr[mid] > target){
                return search(arr, target, si, mid-1);
            }

            //case b: right side of mid of First line
            else {
                return search(arr, target, mid+1, ei);
            }
        }

        //CASE 2: MID IS ON RIGHT LINE
        else{
            //case c: right side of mid of second line
            if(arr[mid] < target && arr[ei] >= target){
                return search(arr, target, mid+1, ei);
            }

            //case d: left side of mid of second line
            else{
                return search(arr, target, si, mid-1);
            }
        }

    }
    
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int idx = search(nums, target, 0, nums.length-1);
        System.out.println(idx);
    }
}
