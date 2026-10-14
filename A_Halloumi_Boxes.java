
import java.util.Scanner;

/**
 * A_Halloumi_Boxes
 */
public class A_Halloumi_Boxes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            if(checkSorted(arr)){
                System.out.println("YES");
                continue;
            }
            if(k == 1){
                System.out.println("NO");
            } else if(k > 1) {
                System.out.println("YES");
            }
        }

        sc.close();
    }

    public static boolean checkSorted(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }

        return true;
    }
}