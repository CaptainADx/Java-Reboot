public class decreasingOrder {
    public static void printDecreasing(int n){
        if( n == 1){
            System.out.println(n);
            return;
        }
        printDecreasing(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args){
        int n = 10;
        printDecreasing(n);
    }
}
