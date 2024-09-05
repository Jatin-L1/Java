package Assignments.Sorting;

import java.util.Scanner;

public class checksorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the value in array: ");
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for(int i =0;i<n;i++){
            if(arr[i] -1 == i){
                System.out.println("Array is fully sorted");
                break;
            }
            if(arr[i]+1 ==i){
                count++;
            }
            else{
                System.out.println("Not sorted");
                break;
            }

        }
        if (count > 2) {
            System.out.println("Not sorted");
        }

        sc.close();
    }
}
