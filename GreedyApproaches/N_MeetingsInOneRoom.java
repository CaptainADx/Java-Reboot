import java.util.Arrays;
import java.util.Comparator;

public class N_MeetingsInOneRoom {
    
    public static void findMeetingSequence(int[] start, int[] end) {
        int[][] meetings = new int[start.length][3];
        for(int i=0; i<start.length; i++ ){
            meetings[i][0] = i+1;
            meetings[i][1] = start[i];
            meetings[i][2] = end[i];
        }

        //This array will be used to store the Sequence of Jobs
        int[] arr = new int[start.length];
        Arrays.fill(arr, -1);

        //Initially All Jobs are sorted in Ascending order of End Time
        Arrays.sort(meetings, Comparator.comparing(a -> a[2]));
        
        int trackArr = 1; //This variable is Just a point to Array --> arr
        int lastEndTime = meetings[0][2];
        arr[0] = meetings[0][0];

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][1] >= lastEndTime) {
                lastEndTime = meetings[i][2]; 
                arr[trackArr++] = meetings[i][0];
            }
        }
        for(int i : arr){
            if(i == -1) continue;
            System.out.print("Job" + i + "   ");
        }
    }

    public static void main(String[] args) {
        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end = {5, 4, 2, 9, 7, 9};

        findMeetingSequence(start, end);
        
    }
}
