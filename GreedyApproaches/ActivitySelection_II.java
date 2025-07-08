import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class ActivitySelection_II {
    
    //Here we will consider the case in which the Activities are not sorted on basis of end time;
    public static void main(String[] args) {
        

        int[] startTime = {1, 3, 0, 5, 8, 5};
        int[] endTime =   {2, 4, 6, 7, 9, 9};

        //Creating a 2-D array to store the Actual sequence of Activities(index, startTime, endTime)
        int[][] activities = new int[endTime.length][3];

        //Filling the 2-D arrya with the elements;
        for(int i=0; i<endTime.length; i++){
            activities[i][0] = i;
            activities[i][1] = startTime[i];
            activities[i][2] = endTime[i];
        }

        //Sorting the 2-D Array based on EndTime Column. (For this we Are using COMPARATOR INTERFACE)
        //Lambda function -> Short Form
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));


        ArrayList<Integer> res = new ArrayList<>();

        //Step 1 : Add the first activity in the result
        res.add(activities[0][0]); //Add the first activity in the array 
        int maxActivity = 1; // Maximum number of activities that can be done is 1
        int lastEndTime = activities[0][2]; // stores the end time of first task

        //Step 2 : iterate over the endtime array and select the Activities that are not overlapping
        for(int i=1; i<activities.length; i++){
            //select only Non-Overlapping activities
            if(activities[i][1] >= lastEndTime){
                maxActivity++;
                res.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }

        System.out.println("Max Activities --> " + maxActivity);
        
        for(int i=0; i<res.size(); i++){
            System.out.print("A"+res.get(i) + " ");
        }
    }
}   
