class Test {
    public static void main(String[] args) {
        //Declaration of the matrix
        int[][] nums = {
                        {2, 0, 0, 0, 0},
                        {0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 7, 0},
                        {0, 6, 0, 0 ,0}
                    };

        
                    //Initializing count variable
        int cnt = 0;

        // Counting number of meaningful elements
        for(int[] num : nums){
            for(int ele : num){
                if(ele != 0){
                    cnt++;
                }
            }
        }

        // Declaring sparse matrix representation
        int[][] smr = new int[3][cnt];

        int k = 0;
        
        //Iterating over each Column of Sparse matrix representation
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[0].length; j++){
                if(nums[i][j] != 0){
                    smr[0][k] = i;
                    smr[1][k] = j;
                    smr[2][k] = nums[i][j];
                    k++;

                }
            }
        }

        

        for(k=0 ;k<smr[0].length; k++){
            System.out.println("row --> " + smr[0][k]);
            System.out.println("col --> " + smr[1][k]);
            System.out.println("ele --> " + smr[2][k]);
            System.out.println("*********************");
        }

    }
}