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

    
    public static int findPointOfRotationIteative(int[] arr, int si, int ei){
        // If the array is not rotated at all
        if (arr[si] <= arr[ei]) {
            return 0;
        }

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            // Check if mid is the rotation point
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            }

            // Decide the direction to move
            if (arr[mid] >= arr[si]) {
                si = mid + 1;  // Rotation point is in right half
            } else {
                ei = mid - 1;  // Rotation point is in left half
            }
        }

        return 0;  // Fallback (shouldn't happen for valid rotated arrays)
    }
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        int idx = findPointOfRotationIteative(arr, 0, arr.length-1);
        System.out.println(idx);
    }
}
