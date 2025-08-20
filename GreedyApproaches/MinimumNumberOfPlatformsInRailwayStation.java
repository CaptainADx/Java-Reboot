
import java.util.Arrays;

class MinimumNumberOfPlatformsInRailwayStation{
    //In this question we need to find minimum number of platforms required for Smooth running of all Trains
    public static void main(String[] args) {
        int[] arrival = {900, 945, 955, 1100, 1500, 1800};
        int[] departure = {920, 1200, 1130, 1150, 1900, 2000};

        //First we will sort both Arrays independently coz we dont need to maintain order...
        //We just need to observe when a train is reaching and when is one departing...

        Arrays.sort(arrival);
        Arrays.sort(departure);

        //Now we will keep a count when a train is reaching and when its leaving

        int maxCount = 0;
        int count = 0;

        int i = 0, j = 0;

        while(i<arrival.length && j<departure.length){
            if(arrival[i] < departure[j]){
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}