public class FloorAndCeilValues {

    // If X is a Value
    // Floor value is the Largest Number in Array <= X    --> This is Something Different
    // Ceil Value is the Smallest Number in Array >= X    --> This is Nothing but the Lower Bound Case


    public static int findFloorValue(int[] arr, int X){
        int low = 0, high = arr.length-1;
        int res = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] <= X){
                res = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return res;
    }

    public static int findCeilValue(int[] arr, int X){
        int low = 0, high = arr.length-1;
        int res = arr.length;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] >= X){
                res = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40 , 50, 60};
        int X = 45;
        int floor = findFloorValue(arr, X);
        int ceil = findCeilValue(arr, X);

        System.out.println("Floor Value is --> " + floor);
        System.out.println("Ceil Value is --> " + ceil);
     }
}
