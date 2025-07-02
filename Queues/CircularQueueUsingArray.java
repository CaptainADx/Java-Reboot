public class CircularQueueUsingArray {
    public static class Queue{
        static int[] arr;
        static int front;
        static int rear;
        static int size;

        Queue(int n){
            arr = new int[n];
            front = -1;
            rear = -1;
            size = n;
        }

        public boolean isEmpty(){
            return (rear == -1 && front == -1);
        }

        public boolean isFull(){
            return (rear+1)%size == front;
        }

        public void add(int data){
            if(isFull()){
               System.out.println("Queue is Full");
               return; 
            }
            if(front==-1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        public int delete(){
            if(isEmpty()){
                System.out.println("Queue is Already Empty");
                return -1;
            }
            int deleted = arr[front];
            if(front == rear){
                front = rear = -1;
            } else{
                front = (front+1)%size;
            }
            return deleted;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

    }
    public static void main(String[] args){
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.delete();
        q.add(6);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.delete();
        }
    }
}
