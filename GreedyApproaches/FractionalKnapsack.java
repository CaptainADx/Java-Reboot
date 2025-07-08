import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {
    
    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        float capacity = 50;
        List<String> items = new ArrayList<>();

        //Calculate the faction of value/weight for max profit and store in 2-D Array
        double[][] fraction = new double[weight.length][2];
        for(int i=0; i<weight.length; i++){
            double frac = (double)value[i]/weight[i];
            frac = Math.round(frac*100)/100;
            
            fraction[i][0] = i;
            fraction[i][1] = frac;
        }

        //Writing Lambda function and using Comparator funtion to Sort the Array on basis of 2nd Column
        Arrays.sort(fraction, Comparator.comparingDouble(o -> o[1]));

        //Start Filling the KnapSack
        float spaceAvailable = capacity;
        float totalProfit = 0;
        for(int i=fraction.length-1; i>=0; i--){
            if(spaceAvailable >= weight[(int)fraction[i][0]]){
                spaceAvailable -= weight[(int)fraction[i][0]];
                totalProfit += value[(int)fraction[i][0]];
                items.add("I"+ (int)fraction[i][0] + " in Full Quantity");
            } else {
                totalProfit += fraction[i][1] * spaceAvailable;
                items.add("I"+ (int)fraction[i][0] + " in Quantity " + spaceAvailable);
                break;
            }
        }

        System.out.println("Total Profit --> " + totalProfit);

        System.out.println(items);
    }
}
