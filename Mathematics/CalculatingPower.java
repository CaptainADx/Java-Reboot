public class CalculatingPower {
    public long pow(long x, long n){
        long res = 1;
        while(n>0){
            if((n&1) == 1){
                res = res*x;
            }
            x = x*x;
            n = n/2;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new CalculatingPower().pow(3, 5));
    }
}
