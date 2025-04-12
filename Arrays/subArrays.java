class subArrays {

    public static void printSubArrays(int[] arr){
        int minSum = arr[0];
        int maxSum = arr[0];
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int currSum = 0;
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k] +" ");
                    currSum += arr[k];
                }
            minSum = Math.min(minSum, currSum);    //Checking for Min Sum
            maxSum = Math.max(maxSum, currSum);    //Checking for Max Sum
            System.out.print(" <---Current Sum is : --> " + currSum);
            System.out.println();
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        
        System.out.println("Min Sum : " + minSum);
        System.out.println("Max Sum : " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        printSubArrays(arr);

    }
}