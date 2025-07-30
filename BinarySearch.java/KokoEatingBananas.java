
import java.util.Arrays;

public class KokoEatingBananas {

    // Find minimum number of Bananas KOKO must eat per unit time
    // Such that total time taken to Eat all bananas is Less than Total Time Given (H)

    public static int kokoEatingBananas(int[] piles, int h){
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while(low <= high){
            int mid = low + (high-low) /2;

            if(canEatAllPiles(piles, h, mid)){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }

    public static boolean canEatAllPiles(int[] piles, int h, int k){
        long totalHours = 0;
        for(int pile : piles){
            totalHours += (long) Math.ceil((double)pile / (double)k);
        }
        return totalHours <= h;

    }
    
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 8, 11};
        int h = 8;

        int minimumBananasPerUnitTime = kokoEatingBananas(piles, h);
        System.out.println("Koko must eat " + minimumBananasPerUnitTime + " Bananas to finish in " + h +" Hours");
    }
}
