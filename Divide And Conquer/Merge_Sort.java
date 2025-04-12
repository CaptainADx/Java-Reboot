public class Merge_Sort {
    
    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei-si) /2;

        mergeSort(arr, si, mid); //for left part
        mergeSort(arr, mid+1, ei); //for right part

        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei){

        int[] temp = new int[ei-si + 1];        //creating a temp array

        int i=si;           // iterator for left part
        int j=mid+1;        // iterator for right part
        int k =0;           // iterator for temp array

        while(i<=mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
            k++;
        }
        
        //if all elements of Right Array are Completed Put the Remaining elements of Left Array
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        //if all elements of Left Array are Completed Put the Remaining elements of Right Array
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        for(i=si, k=0; i<=ei; i++,k++){
            arr[i] = temp[k];
        }
        
    }

    public static void main(String[] args){
        int[] arr = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
} 