import java.util.Arrays;

class AggressiveCows{
    // We need to find the (Minimum distance between Cows such that All cows can be placed)
    // The Minimum distance must the maximum of all Possible configurations.

    public static int findMaxOfAllMinDistance(int[] cowStalls, int totalCows){
        int low = 1;
        int high = cowStalls[cowStalls.length - 1] - cowStalls[0];
        int ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(canPlaceCows(cowStalls, totalCows, mid)){
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return ans;
    }

    public static boolean canPlaceCows(int[] cowStalls, int totalCows, int lastPossible){
        int cowsCount = 1;
        int last = cowStalls[0];

        for(int i=1; i<cowStalls.length; i++){
            if(cowStalls[i] - last >= lastPossible){
                cowsCount++;
                last = cowStalls[i];
            }
        }

        return cowsCount >= totalCows;
    }

    public static void main(String[] args) {
        int[] cowStalls = {0, 3, 4, 7, 10, 9};
        int totalCows = 4;

        //First we will sort the array.
        Arrays.sort(cowStalls);

        //Then we need to check only the distance between the adjacent cows for minimum distance
        int minDist = findMaxOfAllMinDistance(cowStalls, totalCows);

        
        System.out.println("The minimum distance is --> " + minDist);

    }
}