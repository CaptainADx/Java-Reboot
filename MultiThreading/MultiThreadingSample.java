public class MultiThreadingSample {
    
    public static class VideoStreaming implements Runnable {
        
        @Override
        public void run(){
            System.out.println("Video Streaming Started");
            for(int i = 0; i < 10; i++){
                System.out.println("Streaming...");
                try{
                    Thread.sleep(2000);
                } catch(InterruptedException e){
                    System.err.println("Video Streaming Interrupted: " + e.getMessage());
                }
            }
            System.out.println("Video Streaming Stopped");
        }
    }

    public static class Downloading implements Runnable {
        @Override
        public void run(){
            System.out.println("Downloading Started");
            for(int i=0; i<=100; i+=10){
                try {
                    System.out.println("Downloading " + i + "%");
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    System.err.println("VideoStreaming Interrupted: " + ex.getMessage());
                }
            }
            System.out.println("Downloading Completed");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        VideoStreaming vs = new VideoStreaming();
        Downloading dw = new Downloading();

        Thread t1 = new Thread(vs);
        Thread t2 = new Thread(dw);

        t1.start();
        t2.start();
    }
}
