package Quick_SORT;

import java.util.ArrayList;
public class practise {
    static ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {4,9,7,1,2,3,6,5,8};
        answer = new ArrayList<>();

        quicksort(arr , 0 , arr.length-1);
        System.out.println(answer);
    }

    public static void quicksort(int[] arr , int lo , int hi) {
        if(lo>=hi) {
            ArrayList<Integer> newList = new ArrayList<>();
            for(int ele : arr){
                newList.add(ele);
            }
            answer.add(newList);
            return;
            
        }
        int idx  = partition(arr , lo , hi);
        quicksort(arr , lo , idx-1);
        quicksort(arr , idx+1 , hi);

    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo] , pivotIdx = lo;
        int smallerCount = 0;
        for(int i = lo+1 ; i<=hi;i++){
            if(arr[i]<=pivot) smallerCount++;
        }
        int CorrectIdx = pivotIdx + smallerCount;
        swap(arr, pivotIdx , CorrectIdx);
        int i = lo , j = hi;

        while(i<CorrectIdx && j>CorrectIdx){
            if(arr[i]<=pivot) i++;
            else if(arr[j] >pivot) j--;
            else if(arr[i]>pivot && arr[j]<pivot){
                swap(arr , i ,j);
            }
        }
        return CorrectIdx;
    }

    public static void swap(int[] arr, int pivotIdx, int smallerCount) {
        int temp = arr[pivotIdx];
        arr[pivotIdx] = arr[smallerCount];
        arr[smallerCount] = temp;
    }
    
}
