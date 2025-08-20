import java.util.ArrayList;

public class InsertInterval {

    public static ArrayList<ArrayList<Integer>> newInsertedIntervals(int[][] intervals, int[] newInterval){
        ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
        ArrayList<Integer> curr;
        int n = intervals.length;
        
        int i=0;

        while((i < n) &&(intervals[i][1] < newInterval[0] )){
            curr = new ArrayList<>();
            curr.add(intervals[i][0]);
            curr.add(intervals[i][1]);

            newList.add(curr);
            i++;
        }

        while((i<n) && (intervals[i][0] <= newInterval[1])){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        curr = new ArrayList<>();
        curr.add(newInterval[0]);
        curr.add(newInterval[1]);
        newList.add(curr);


        while(i< n){
            curr = new ArrayList<>();
            curr.add(intervals[i][0]);
            curr.add(intervals[i][1]);

            newList.add(curr);
            i++;
        }

        return newList;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {3,4}, {6,7}, {8,10}, {12,16}};
        int[] newInterval = {5,8};

        System.out.println(newInsertedIntervals(intervals, newInterval));
    }
}
