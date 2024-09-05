package Assignments.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class mergetwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of array: " );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Please enter the size of array: " );
        int m = sc.nextInt();
        int[] brr = new int[m];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < m; i++){
            brr[i] = sc.nextInt();
        }
        ArrayList<Integer> xrr = new ArrayList<>(m+n);
        for(int i = 0;i<n;i++){
            xrr.add(arr[i]);
        }
        for(int j =0;j<m;j++){
            xrr.add(brr[j]);
        }
        Collections.sort(xrr);
        for(int i = 0;i<m+n;i++){
           System.out.print(xrr.get(i) +" "); 
        }

        sc.close();

}
}
