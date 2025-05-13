import java.util.Arrays;

public class SieveOfEratosthenes {
    /*
    This algorithm is used to find all prime numbers in a range of 1 to N.
    Instead of checking for each number that if it is prime or not which takes O(n√n),
    Sieve of Eratosthenes marks all the composite numbers as false and what left in boolean array
    are the prime numbers marked with true.
    Time Complexity : O(n log(logn))
    Space Complexity : O(n)
    Works well if N <= 1 million
    
    The Sieve uses a boolean array of size n + 1.
    Each boolean in Java is 1 byte (though technically, it uses 1 bit logically, Java allocates 1 byte).
    So, for n = 10^6, the array takes about 1 MB of memory, which is fine.
    But for n = 10^8 (100 million), it takes 100 MB just for the array, which can lead to OutOfMemoryError if your heap is small.
    */

    public static void primeNumbersInRange(int num){
        boolean[] allPrimes = new boolean[num+1];
        Arrays.fill(allPrimes, true);

        allPrimes[0] = allPrimes[1] = false;

        for(int p=2; p*p <= num; p++){
            if(allPrimes[p]){
                for(int i=p*p; i <= num; i+=p){
                    allPrimes[i] = false;
                }
            }
        }

        for(int i=2; i<allPrimes.length; i++){
            if(allPrimes[i]){
                System.out.print(i + " ");
            }
        }
    } 

    public static void main(String[] args) {
        int num = 100;
        primeNumbersInRange(num);
    
    }
}
