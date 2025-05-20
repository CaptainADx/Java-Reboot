public class Print1toN {
    public static void printNumbers(int number){
        if(number == 0){
            return;
        }
        printNumbers(number-1);
        System.out.print(number + " ");
    }
    public static void main(String[] args) {
        int n = 10;
        printNumbers(n);
    }
}
