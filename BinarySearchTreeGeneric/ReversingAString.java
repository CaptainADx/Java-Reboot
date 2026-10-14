class ReversingAString {

    public static int printLargest(int[] arr, int n){

        int largest = Integer.MIN_VALUE;

        for(int ele : arr){
            largest = Math.max(largest, ele);
        }

        return largest;
        
    }

    public static void main(String[] args) {
        int[] arr = {1 , 10, 2, 6, 7, 17, 5};
        int n = arr.length;

        System.out.println(printLargest(arr, n));
    }
}