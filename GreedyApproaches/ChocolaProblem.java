
import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    
    public static void main(String[] Args){
        Integer[] costVer = {2,1,3,1,4};
        Integer[] costHor = {4,1,2};

        // int n=4, m=6;  // this is the total number of square pieces in the whole Chocola Bar.

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0, v=0;
        int hp=1, vp=1;   //Horizontal and Vertical pieces
        int cost = 0;  //total cost to cut into pieces

        while(h<costHor.length && v < costVer.length){
            if(costHor[h] >= costVer[v]){
                cost += (costHor[h] * vp);
                h++;
                hp++;
            } else {
                cost += (costVer[v] * hp);
                v++;
                vp++;
            }
        }

        while(h < costHor.length){
            cost += (costHor[h] * vp);
            h++;
            hp++;
        }

        while(v < costVer.length){
            cost += (costVer[v] * hp);
            v++;
            vp++;
        }

        System.out.println("Minimum total cost --> " + cost);
    }
}
