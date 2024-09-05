package Assignments.Strings;

import java.util.Scanner;

public class secondlargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = str.charAt(i);
        }
        int max = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;

        for(int i =0;i<n;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]>secondlargest && arr[i]<max) secondlargest = arr[i];
        }
        // System.out.print((char)(max));
        System.out.print((char)(secondlargest));
        // for(int ele : arr){
        //     System.out.print(ele+" ");
        // }
        sc.close();
    }
}
