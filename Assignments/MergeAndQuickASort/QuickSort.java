package Assignments.MergeAndQuickASort;

public class QuickSort {
    public static void print(int[] arr) {
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        
    }


    public static int  partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo] , pivotIndex = lo;
        int smallerCount = 0;
        for(int i =lo+1; i <=hi;i++){
            if (arr[i]<=pivot) { smallerCount++;      
            }
        }
        int correctIdx = pivotIndex + smallerCount;
        swap(arr,pivotIndex,correctIdx);
        int i = lo , j=hi;
        while (i<correctIdx && j>correctIdx) {
            if (arr[i]<pivot) {
                i++;
            }
            else if (arr[j]>pivot) {
                j--;
                
            }
            else if (arr[i]>pivot &&arr[j]<pivot) {
                swap(arr, i, j);
            }   
        }
        return correctIdx;

    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
    public static void quicksort(int[] arr, int lo, int hi) {
        int n = arr.length;
        if (lo>=hi) {
            return;
        }
        int index = partition(arr, lo, hi);
        quicksort(arr, lo, index-1);
        quicksort(arr, index+1, hi);

    }


    public static void main(String[] args) {
        int[] arr ={3,8,6,7,5,9,10};
        print(arr);
        System.out.println();
        quicksort(arr, 0 , arr.length-1);
        print(arr);
    }

    
}
