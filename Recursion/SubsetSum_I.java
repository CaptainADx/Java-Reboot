import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum_I {
    
    public static void findSubsetSum(int[] arr, int idx, int sum, List<Integer> res){
        if(idx == arr.length){
            res.add(sum);
            return;
        }

        findSubsetSum(arr, idx+1, sum, res);
        findSubsetSum(arr, idx+1, sum+arr[idx], res);
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1};
        int idx = 0;
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        findSubsetSum(arr, idx, sum, res);
        Collections.sort(res);
        System.out.println(res);
    }
}
