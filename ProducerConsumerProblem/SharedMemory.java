public class SharedMemory {
    int buffer;
    boolean flag = false;
    
    synchronized public void produce(int data) throws Exception{
        if(flag == true){
            wait();
        }
        System.out.println("Item is produced " + data);
        buffer = data;
        flag = true;
        notify();
       
    }

    synchronized public int consume() throws Exception{
        if(flag == false){
            wait();
        }

        System.out.println("Item is consumed " + buffer);

        flag = false;
        notify();
        return buffer;
    }
}
