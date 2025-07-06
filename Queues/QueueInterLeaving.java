import java.util.LinkedList;
import java.util.Queue;

public class QueueInterLeaving {

    static void queueInterLeave(Queue<Integer> q1){
        int n = q1.size();
        if(n==0){
            System.out.println("Queue is Empty");
        }
        if(n==1){
            System.out.println("Only One element, No inter-leaving is needed");
        }
        if(n>1){
            Queue<Integer> q2 = new LinkedList<>();
            for(int i=0; i<n/2; i++){
                q2.add(q1.remove());
            } 
            while(!q2.isEmpty()){
                q1.add(q2.remove());
                q1.add(q1.remove());
            }
            /*
            THE BELOW LINE IS OPTIONAL AS NEEDED OR ASKED IN QUESTION
            UNCOMMENT THIS IF YOU STRICTLY WANT THE FIRST ELEMENT TO STAY IN SAME POSITION.
            */
            // if((n&1) != 0){
            //     q1.add(q1.remove());
            // }
        }

    }
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        q.add(11);

        queueInterLeave(q);
        
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
    }
}
