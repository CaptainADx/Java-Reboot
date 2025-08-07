

public class Consumer extends Thread{
    SharedMemory shm;

    public Consumer(SharedMemory shm) {
        this.shm = shm;
    }

    @Override
    public void run(){
        while (true) { 
            try{
                int item = shm.consume();
            
                Thread.sleep(1000);
            } 
            catch (Exception ex) {}
            
        }
    }
}
