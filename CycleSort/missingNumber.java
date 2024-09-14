package CycleSort;

public class missingNumber {
    
     public static void swap(int[]arr,int i, int j) {
            int temp  = arr[i];
            arr[i] = arr[j];
            arr[j]=temp;
    }
    public static int  cycleSort(int[] arr) {
        int n = arr.length;
        int i =0;
        while(i<n){
            if(arr[i]==n || arr[i]==i) i++;
            else{
                swap(arr,i,arr[i]);
            }
        }
        for(i=0;i<n;i++){
            if(arr[i]!=i) return i;
        }
        return n;
    }
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};

        System.out.println(cycleSort(arr));
    }

    
}
