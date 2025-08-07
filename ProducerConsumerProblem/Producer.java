
public class Producer extends Thread{
    SharedMemory shm;

    Producer(SharedMemory shm) {
        this.shm = shm;
    }

    @Override
    public void run(){
        int i = 1;
        while (true) { 
            try{
                shm.produce(i++);
                Thread.sleep(1000);
            } 
            catch (Exception ex) {}
        }
        
    }

} 
