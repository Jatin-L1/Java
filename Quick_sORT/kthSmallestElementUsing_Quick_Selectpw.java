package Quick_SORT;

public class kthSmallestElementUsing_Quick_Selectpw {
    static int ans;

    public static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }
    public static void swap(int[] arr , int lo , int hi){
        int temp = arr[lo];
        arr[lo] =arr[hi];
        arr[hi] = temp;
    }
    public static int partition(int [] arr , int lo , int hi){
        int mid = (lo+hi)/2;   
        
        int pivot = arr[mid] , pivotIdx = mid;
        // int pivot = arr[lo] , pivotIdx = lo;
        int smallerCount = 0;
        for(int i =lo+1;i<=hi;i++){
            if(i==mid) continue;
            if(arr[i]<=pivot) smallerCount++;
        }
        // int correctIdx = pivotIdx + smallerCount;
        int correctIdx = lo + smallerCount;
        // swap(arr , lo , correctIdx);
        swap(arr , pivotIdx , correctIdx);
        //partition
        int i = lo ,j=hi;
        while(i<correctIdx && j>correctIdx){
            if(arr[i]<=pivot) i++;
            else if (arr[j]>pivot) {
                j--;
            }
            else if (arr[i]>pivot && arr[j]<=pivot) {
                swap(arr,i,j);   
            }
        }
        return correctIdx;

    }
    public static void quickSelect(int [] arr , int lo , int hi,int k){
        if(lo>hi) return;
        if(lo==hi){
            if(lo==k-1) ans = arr[lo];
            return;
        }
        int idx = partition(arr, lo, hi);
        if (idx==k-1) {
            ans=  arr[idx];
            return;
            
        }
        if(k-1 <idx) quickSelect(arr, lo, idx-1,k);
        else  quickSelect(arr, idx+1, hi,k);

    }


    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int n = arr.length;
        print(arr);
        int k = 2;
        ans = -1;
        quickSelect(arr, 0, n-1,n-k+1);
        System.out.println();
        print(arr);
        System.out.println();
        System.out.println(ans);
    }


    
}
