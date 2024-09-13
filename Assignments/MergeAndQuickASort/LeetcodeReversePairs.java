package Assignments.MergeAndQuickASort;

public class LeetcodeReversePairs {
    static int sum = 0;
    public static int inversion(int[] a, int[] b) {
        int i = 0 , j =0;
        int count = 0;
        while (i<a.length && j<a.length) {
            if (a[i]>2* (long)b[j]) {
                count += a.length-i;
                j++;
            }
            else i++;
            
        }
        return count;
    }
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n<2 ) return;
        int[] a  =new int[n/2];
        int[] b = new int[n-n/2];
        for(int i =0;i<n/2;i++){
            a[i] = arr[i];
        }
        for(int i =0;i<n-n/2;i++){
            b[i] = arr[i+n/2];
        }
        mergeSort(a);
        mergeSort(b);
        sum = sum+  inversion(a,b);
        merge(a,b,arr);
        System.out.println(sum);
    }
    public static void merge(int[] a, int[] b, int[] c) {
        int  i =0 ,j=0,k=0;
        while (i<a.length && j<b.length) {
            if (a[i]<=b[j]) {
                c[k++] = a[i++];
            }
            else{
                c[k++] = b[j++];
            }  
        }
        if(i==a.length){
            while (j<b.length) {
                c[k++] = b[j++];
            }
        }
        if(j==b.length){
            while (i<a.length) {
                c[k++] = a[i++];
                
            }
        }
        
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        mergeSort(arr);
        System.out.println(Math.max(sum , sum));
        
    }

    
}
