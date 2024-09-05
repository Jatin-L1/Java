package Arrays;

import java.util.Scanner;

public class ReverseanArray {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i =0;i<n;i++){
          System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n/2;i++){
          int j = n-i-1;
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
        for(int i =0;i<n;i++){
          System.out.print(arr[i]+" ");
        }
        sc.close();
}
}
