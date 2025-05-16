public class OneOddOccuringNumber {

    public static int findOddOccuringNumber(int[] arr){
        int res = arr[0];
        for(int i=1; i<arr.length; i++){
            res ^= arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,5,3,4};
        System.out.println(findOddOccuringNumber(arr));
    }
}
