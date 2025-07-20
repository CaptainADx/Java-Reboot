public class FindUpperBound {

    public static int findUpperBoundOfXRecursive(int[] arr, int low, int high, int x, int res){
        if(low>high){
            return res;
        }
        
        int mid = low + (high-low)/2;

        if(arr[mid] > x){
            res = mid;
            return findUpperBoundOfXRecursive(arr, low, mid-1, x, res);
        } else {
            return findUpperBoundOfXRecursive(arr, mid+1, high, x, res);
        }
        
    }

    public static int findUpperBoundOfXIteritive(int[] arr, int x){
        int low = 0, high = arr.length-1;
        int res = 10;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid] > x){
                res = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 3, 5, 8, 8, 10, 10, 11}; 
        int X = 10;
        // int LB = findUpperBoundOfXRecursive(arr, 0, arr.length-1, X, arr.length); //Recursive Approach
        int LB = findUpperBoundOfXIteritive(arr, X); //Iterative Approach
        System.out.println("Lower Bound of " + X + " is --> " + LB);
    }
}
