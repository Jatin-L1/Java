package Arrays.DutchFlagAlgorithm;

import java.util.Scanner;

public class DGA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int mid = 0, hi=n-1,lo=0; 
        while (mid<=hi) {
            if (arr[mid]==0) {
                int temp = arr[mid];
                arr[mid]=arr[lo];
                arr[lo]=temp;
                lo++ ; mid++;
            }
            else if (arr[mid]==1) {
                mid++;
            }
            else{//arr[mid]==2
                int temp = arr[mid];
                arr[mid]=arr[hi];
                arr[hi]=temp;
                hi--;
            }
        }
        for(int ele:arr){
            System.out.print(ele + " ");
        }
        sc.close();

    }
    
       

}
