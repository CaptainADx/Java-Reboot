import java.util.ArrayList;
import java.util.List;

public class Kth_Permutation {
    public static String findKthPermutationSequence(int n, int k){
        List<Integer> list = new ArrayList<>();
        int fact = 1;

        for(int i=1; i<=n; i++){
            fact*=i;    // Total number of possible permutations
            list.add(i);
        }

        fact /= list.size();  //Each starting number can generate this amount of permutations
        k = k-1;
        StringBuilder sb = new StringBuilder();
        while(true) { 
            sb.append(list.get(k/fact));
            list.remove(k/fact);

            if(list.isEmpty()){
                break;
            }

            k %= fact;
            fact /= list.size();
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        // We are given with a Number N.. such that List is [1, 2, 3, ... , N]
        // We need to find the K-th Permutation sequence and print it.
        int n = 4;
        int k = 17;

        String seq = findKthPermutationSequence(n, k);

        System.out.println("The K-th permutation sequence is --> " + seq);
    }
}
