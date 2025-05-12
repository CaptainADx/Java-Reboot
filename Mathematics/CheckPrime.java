public class CheckPrime {
    //Its the optimized method for checking prime or not.
    public static boolean isPrime(int num){
        if(num == 2 || num == 3){
            return true;
        }
        if(num % 2 == 0 || num % 3 == 0){
            return false;
        }
        for(int i=5; i*i < num; i = i+6){
            //here inside loop we start with checking divisible with 5 or 7 if thats not the case
            //then we increase the number by six coz... 6,(seven is checked), 8, 9, 10 are all checked 
            //in the case of (num%2) and (num%3)
            if(num%i == 0 || num%(i+2) == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(241));
    }
}
