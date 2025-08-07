
public class TestSycn{

    public static void main(String[] args) {

        Brackets b = new Brackets();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                b.printBrackets('{', '}');
            }
        });

        Thread t2 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    b.printBrackets('[', ']');
                }
            }
        );

        t1.start();
        t2.start();
    }
    
}
