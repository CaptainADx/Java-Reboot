
public class LCM {
    public static int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args){
        int a = 10;
        int b = 15;

        //LCM can be calculated by the Formula -->  (a*b) divided by gcd(a,b)
        int lcm = (a*b)/gcd(a, b);
        System.out.println(lcm);
    }
}
