public class CircularQueueUsingArray {
    public static class Queue{
        public static int[] arr;
        public static int size;
        public static int rear;
        public static int front;

        Queue(int n){
            arr = new int[n];
            rear = -1;
            front = -1;
            size = n;
        }

        public boolean isEmpty(){
            return (rear==-1 && front==-1);
        }

        public boolean isFull(){
            return (rear+1)%size == front;
        }

        public void add(int data){
            if(isFull()){
                System.out.println("Queue is already Full");
                return;
            }
            if(front == -1){
                front=0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = arr[front];
            if(rear == front){
                rear = front = -1;
            } else {
                front = (front+1)%size;
            }
            return result;
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
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
