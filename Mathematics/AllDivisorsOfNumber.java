public class AllDivisorsOfNumber {

    //This function print all Divisors but Order is not sorted
    public static void findAllDivisorsEfficient(int num){
        for(int i=1; i*i < num; i++){
            if(num%i == 0){
                System.out.println(i);
                if(i != num/i){
                    System.out.println(num/i);
                }
            }
        }
    }

    //This function will print all divisors in Sorted Order
    public static void findAllDivisorsOptimized(int num){
        int i;
        for(i=1; i*i <= num; i++){
            if(num%i == 0){
                System.out.println(i);
            }
        }
        //it starts from i-1 coz last loop exits at the false condition which is caused by
        //post increment i++.
        for( i=i-1 ; i>=1 ; i--){
            if(num%i == 0 ){
                System.out.println(num/i);
            }
        }

    }
    public static void main(String[] args) {
        // findAllDivisorsEfficient(20);

        findAllDivisorsOptimized(20);
    }
}
