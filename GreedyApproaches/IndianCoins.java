
import java.util.ArrayList;

public class IndianCoins {
    
    //Find the minimum number of Indian Coins from the coin list to Achieve the Value targetValue.
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int targetValue = 4013;

        int currValueLeftToAchive = targetValue;

        int n = coins.length;
        int totalCoinsRequired = 0;
        ArrayList<Integer> valueCoinsUsed = new ArrayList<>();

        for(int i=n-1; i>=0; i--){
            while(currValueLeftToAchive >= coins[i]){
                currValueLeftToAchive -= coins[i];
                totalCoinsRequired++;
                valueCoinsUsed.add(coins[i]);
            }
        }

        System.out.println("Total Coins Required --> " + totalCoinsRequired);
        System.out.println(valueCoinsUsed);
    }
}
