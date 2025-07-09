import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairs {
    
    public static void main(String[] args){
        //These are the collection of chains
        int[][] pairs = {{5,24}, {39,60}, {5,28}, {27,40}, {50,60}};

         ArrayList<Integer> chainPairs = new ArrayList<>(); //To store all the acceptable pairs

        //Since this problem is similar to Activity selection problem we are using that
        int[][] sortedPairs = new int[pairs.length][3];
        for(int i=0; i<pairs.length; i++){
            sortedPairs[i][0] = i;
            sortedPairs[i][1] = pairs[i][0];
            sortedPairs[i][2] = pairs[i][1];
        }

        //Sorting the array based on 2nd column.... since for two chains (a,b) and (c,d) -->  b<c
        Arrays.sort(sortedPairs, Comparator.comparingInt(o -> o[2]));

        int previousChainEndPoint = sortedPairs[0][2]; //This will store the last connection point of current chain
        int maxLengthChain = (sortedPairs[0][2] - sortedPairs[0][1]); //To track the exact length of the chain formed
        int maxPairCount = 1;  //To track how many pairs are considered

        chainPairs.add(sortedPairs[0][0]);

        for(int i=1; i<sortedPairs.length; i++){
            if(sortedPairs[i][1] > previousChainEndPoint){
                maxLengthChain += (sortedPairs[i][2] - sortedPairs[i][1]);
                previousChainEndPoint = sortedPairs[i][2];
                chainPairs.add(sortedPairs[i][0]);
                maxPairCount++;
            }
        }
        System.out.println("Maximum length of chain formed is --> " + maxLengthChain);
        System.out.println("Maximum Pair count --> " + maxPairCount);

        for(int i=0; i<chainPairs.size(); i++){
            System.out.print(chainPairs.get(i) + " ");
        }
    }
}
