package Assignments.MergeAndQuickASort;
public class MergeSortDescendingOrder {
    public static void print(int[] arr) {
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
    public static void merge(int[] a, int[] b, int[] c) {
        int i = 0 ,j=0,   k =0;
        while (i<a.length && j<b.length) {
            if(a[i]<=b[j]) {
                c[k++] = b[j++];
            }
            else {
                c[k++] = a[i++];
            }  
        }
        if (i==a.length) {
            while (j<b.length) {
                    c[k] = b[j];
                    k++;
                    j++;
            }   
        }
        if (j==b.length) {
            while (i<a.length) {
                c[k] = a[i];
                k++;
                i++;
            }
        }
    }
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if(n==1) return;
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];
        
        for(int i =0;i<n/2;i++){
            a[i] = arr[i];
        }
        for(int i = 0 ; i<n-n/2;i++){
            b[i] = arr[i+n/2];
        }
        mergeSort(a);
        mergeSort(b);
        merge(a , b ,arr);
        a= null;
        b= null;
    }
    public static void main(String[] args) {
        int[] arr = {4,1,8,2,5,9,3};
        print(arr);
        mergeSort(arr);
        System.out.println();
        print(arr);
        
    }
    
    
    
}
