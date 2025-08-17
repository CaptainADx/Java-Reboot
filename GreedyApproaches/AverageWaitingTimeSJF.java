
import java.util.Arrays;

public class AverageWaitingTimeSJF {
    // We need to find the Average waiting time of All the processes
    // The Execution pattern is following Shortest Job First (SJF)

    public static int avgWaitingTime(int[] jobs){
        Arrays.sort(jobs);
        int waitingTime = 0;
        int totalTime = 0;
        for(int i=1; i<jobs.length; i++){
            waitingTime += jobs[i-1];
            totalTime += waitingTime;

            System.out.println("Waiting Time --> " + waitingTime + "\n" + "Total Time --> " + totalTime +"\n");
        }

        int avgWaitingTime = Math.floorDiv(totalTime, jobs.length);

        return avgWaitingTime;
    }

    public static void main(String[] args) {
        int[] jobs = {4, 3, 7, 1, 2};
        // 1 2 3 4 7

        System.out.println("Average Waiting time is --> " + avgWaitingTime(jobs));
    }
}
