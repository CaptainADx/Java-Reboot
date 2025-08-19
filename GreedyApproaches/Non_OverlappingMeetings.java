import java.util.Arrays;
import java.util.Comparator;

public class Non_OverlappingMeetings {
    
    public static int countNonOverlappingMeetings(int[] start, int[] end){
        int n = start.length;
        int[][] meetings = new int[n][3];
        for(int i=0; i<n; i++){
            meetings[i][0] = i+1;
            meetings[i][1] = start[i];
            meetings[i][2] = end[i];
        }

        //Sorting in Increasing order of End time:
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        int count = 1;
        int lastEndTime = meetings[0][2];

        for(int i=1; i<n; i++){
            if(meetings[i][1] >= lastEndTime){
                count++;
                lastEndTime = meetings[i][2];
            }
        }

        return (n - count);
    }

    public static void main(String[] args) {
        int[] start = {0, 3, 1, 5, 5, 7};
        int[] end = {5, 4, 2, 9, 7, 9};

        System.out.println("Total Number of Non-Overlapping meetings --> " + countNonOverlappingMeetings(start, end));
    }
}
