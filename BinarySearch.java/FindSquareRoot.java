class FindSquareRoot{

    public static void main(String[] args) {
        int num = 16;

        //Applying Binary Search to find Square Root of the Num
        int ans = 0;
        int start = 0, end = num;
        while(start <= end){
            int mid = start + (end-start)/2;
            long square = (long) mid*mid;
            if(square == num){
                System.out.println(mid);
                return;
            }

            if(square > num){
                end = mid-1;
            } else{
                ans = mid;
                start = mid+1;
            }
        }
        System.out.println(ans);
    }
}