import java.util.Arrays;

public class MinDayToMakeBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        if ((long) m * k > bloomDay.length) return -1;
        int res = -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int count = 0;
            int totalBouquets = 0;

            for(int i=0; i<bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    count++;
                } else{
                    totalBouquets += (int)Math.floor((double)count/(double)k);
                    count=0;
                }
            }
            totalBouquets += (int)Math.floor((double)count/(double)k);

            if(totalBouquets >= m){
                res = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,13,11,12,7};
        int m = 2;
        int k = 3;

        int minDays = minDays(bloomDay, m, k);

        System.out.println("Minimum Days to Make M bouquets of K size is --> " + minDays);
    }
}
