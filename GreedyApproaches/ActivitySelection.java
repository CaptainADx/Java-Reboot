import java.util.ArrayList;

public class ActivitySelection {
    //Here we will consider the case in which the Activities are sorted on basis of end time;

    public static void main(String[] args){
        int[] startTime = {1, 3, 0, 5, 8, 5};
        int[] endTime =   {2, 4, 6, 7, 9, 9};

        ArrayList<Integer> res = new ArrayList<>();

        //Step 1 : Add the first activity in the result
        res.add(0); //Add the first activity in the array 
        int maxActivity = 1; // Maximum number of activities that can be done is 1
        int lastEndTime = endTime[0]; // stores the end time of first task

        //Step 2 : iterate over the endtime array and select the Activities that are not overlapping
        for(int i=1; i<endTime.length; i++){
            //select only Non-Overlapping activities
            if(startTime[i] >= lastEndTime){
                maxActivity++;
                res.add(i);
                lastEndTime = endTime[i];
            }
        }

        System.out.println("Max Activities --> " + maxActivity);
        
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i) + " ");
        }
    }
}
