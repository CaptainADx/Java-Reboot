public class AllPrimeFactors {
    public static void printAllPrimeFactors(long num){
        if(num <= 1){
            return;
        }
        while(num%2 == 0){
            System.out.println(2);
            num/=2;
        }
        while(num%3 == 0){
            System.out.println(3);
            num/=3;
        }
        for(long i=5; i*i < num; i+=6){
            while(num%i == 0){
                System.out.println(i);
                num/=i;
            }
            while(num%(i+2) == 0){
                System.out.println(i+2);
                num/=(i+2);
            }
        }
        if(num>3){
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        long num = 37837295792834832L;
        printAllPrimeFactors(num);
    }
}
