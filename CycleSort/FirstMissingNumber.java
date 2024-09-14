package CycleSort;

public class FirstMissingNumber {
    public static void swap(int[] arr ,int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static int  MissingPositive(int[] arr) {
        int n = arr.length;
        int i =0;
        while(i<n){
            if (arr[i]<=0 || arr[i]>n || arr[i]==i+1 || arr[i] == arr[arr[i]-1]) i++;
            else{
                swap(arr , i , arr[i]-1);
            }
        }
        for(i =0;i<n;i++){
            if (arr[i]!=i+1) {
                return i+1;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
       System.out.println( MissingPositive(arr));
    }

    
}
