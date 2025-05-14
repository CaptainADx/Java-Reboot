public class CountTotalNumberOfDivisors {
    public static int findAllDivisor(int num){
        //This code has time complexity of O(N * √N)
        int i;
        int count =0;
        for(i=1; i*i<=num; i++){
            if(num%i == 0){
                if(i!=num/i){
                    count+=2;
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findAllDivisor(12));
    }

    /* 
    * NOTE: THIS IS THE LOGIC TO FILTER OUT THE NUMBERS WITH EXACTLY 3 DIVISORS....

     * This could also be optimized by using the logic:
     * A number will have exactly 3 divisors if and only if its a sqare of a prime number
     * Given below is the most optimized approach...
        public static boolean isPrime(int n){
            if (n < 2) return false;
            for (int i = 2; i*i <= n; i++){
                if (n % i == 0) return false;
            }
            return true;
        }

        public int exactly3Divisors(int N) {
            int count = 0;
            for (int i = 2; i*i <= N; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

      This code have time complexity of  O(√N × √√N) and Space complexity of O(1);
    */

}
