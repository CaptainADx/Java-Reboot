public class Tester {
    public static void main(String[] args) {
        Thread_1 t1 = new Thread_1();
        

        Thread_2 A = new Thread_2();    //Thread_2 implements the Runnable interface so we cannot directly call Run()
        Thread t2 = new Thread(A);      //We are creating an object of thread class to use Run

        t1.start();
        t2.start();

        for(int i=1; i<=5; i++){
            System.out.println(Thread.currentThread().getName() + ", i -> " + i);
        }
    }
} 
