public class test {

    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    
    public static void mergeSort(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si) /2 ;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int[ei-si + 1];

        int i=si;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
            k++;
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for(i=si, k=0; i<=ei; i++,k++){
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,3,7,9,2,6};
        mergeSort(arr,0, arr.length-1);
        printArray(arr);
    }
}
