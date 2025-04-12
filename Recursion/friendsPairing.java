import java.util.*;
public class friendsPairing {
    public static int pairs(int n){

        if(n==0){
            return 0;
        }

        if(n==1 || n==2){
            return n;
        }

        return ( pairs(n-1) + (n-1)* pairs(n-2)); 

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        int friendsCount = sc.nextInt();

        System.out.println(pairs(friendsCount));
        sc.close();
    }
}