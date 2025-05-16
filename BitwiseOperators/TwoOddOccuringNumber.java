public class TwoOddOccuringNumber {
    /*
    🔸 Step 1: XOR all elements of the array
        Let this cumulative XOR be xor = A ^ B, where A and B are the two odd-occurring numbers.
        Since all other numbers occur an even number of times, they cancel each other due to the XOR property: a ^ a = 0.

    🔸 Step 2: Find the rightmost set bit in xor
        This bit will be set in one of A or B, but not both (because A ≠ B).
        Formula: rightmostSetBit = xor & -xor

    🔸 Step 3: Divide elements into two groups
        Based on whether the bit at rightmostSetBit position is:
        Set (1) → group 1
        Unset (0) → group 2

    🔸 Step 4: XOR each group separately
        This isolates the two odd-occurring numbers.

        All even-occurring elements will cancel out.
     */
    public static int[] findTwoOddOccuringNumber(int[] arr){
        int res = arr[0];
        for(int i=1; i<arr.length; i++){
            res^=arr[i];
        }
        int k = res &(~(res-1));
        int firstOdd = 0, secondOdd = 0;
        for(int i=0; i<arr.length; i++){
            if((k & arr[i]) != 0){
                firstOdd ^= arr[i];
            } else {
                secondOdd ^= arr[i];
            }
        }
        return new int[] {firstOdd, secondOdd};
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,12,1,6,144,2,5,5,6};
        int[] res = findTwoOddOccuringNumber(arr);
        System.out.println(res[0] +" "+ res[1]);

    }
}
