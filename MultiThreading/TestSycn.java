
public class TestSycn{

    public static void main(String[] args) {

        Brackets b = new Brackets();
        Thread t1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                b.printBrackets('{', '}');
            }
            long end = System.currentTimeMillis();

            System.out.println("T1 exe time -> " + (end-start));
        });

        Thread t2 = new Thread(() -> {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    b.printBrackets('[', ']');
                }
                long end = System.currentTimeMillis();

                System.out.println("T2 exe time -> "+ (end-start));
            }
        );

        t1.start();
        t2.start();
    }
    
}
