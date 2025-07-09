
import java.util.Arrays;

public class MinimumAbsoluteDifference {
    
    public static void main(String[] args){
        int[] A = {4,1,8,7};
        int[] B = {3,2,6,5};
        
        int n = A.length;

        if(A.length != B.length){
            System.out.println(-1);
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for(int i=0; i<n; i++){
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("Minimum Difference is : " + minDiff);
    }
}
