
public class Main {
    public static void main(String[] args) {
        SharedMemory shm = new SharedMemory();
        Producer p = new Producer(shm);
        Consumer c = new Consumer(shm);

        p.start();
        c.start();
    }    
}
