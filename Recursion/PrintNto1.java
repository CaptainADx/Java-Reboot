public class PrintNto1 {

    public static void printNumbers(int number){
        if(number==0){
            return;
        }
        System.out.print(number + " ");
        printNumbers(number-1);
    }
    public static void main(String[] args) {
        int n = 10;
        printNumbers(n);
    }
}
