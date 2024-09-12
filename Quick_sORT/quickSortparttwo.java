package Quick_SORT;

public class quickSortparttwo {
    public static int quicksort(int[] arr, int k , int lo , int hi) {
        int n = arr.length;
        if(lo>=hi){
            return 2435;
        }

        int index = partition(arr ,lo ,hi);
        if(k<index){
            quicksort(arr, k, lo, index-1);
        }
        if (k>index) {
            quicksort(arr, k, index+1, hi);
        }
        return arr[k];
        }
    public static int  partition(int[] arr, int lo, int hi) {
        int n = arr.length;
        int pivot = arr[lo] , pivotIdx = lo ; 
        int smallerCount = 0;
        for(int i =lo+1;i<hi;i++){
            if(arr[i]<=pivot) smallerCount++;
        }
        int CorrectIdx = lo + smallerCount;
        swap(arr,pivotIdx,CorrectIdx);
        int i = lo , j=hi;
        while (i<CorrectIdx && j>CorrectIdx) 
        {
            if (arr[i]<=pivot) {
                i++;
                
            }
            else if (arr[j]>pivot) {
                j--;
                
            }
            else if (arr[i]>pivot && arr[j]<pivot ) {
                swap(arr,i,j);
            }
            
        }
        return CorrectIdx;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {4,9,7,1,2,3,6};
        int k = 6;
        System.out.println(quicksort(arr , k , 0, arr.length-1));
    }

    
}
