package Assignments.Recursion;

import java.util.Scanner;

public class PrintIndex {
    public static int index(int i , int[] arr , int k){
        if (i==arr.length) {
            return 2435;
            
        }

        if(arr[i]==k){
            return i;
        }
        else{
          return index(i+1, arr, k);
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {5,3,7,1,4,9,0};
        System.out.print("Enter K: ");
        int k = sc.nextInt();
        
        System.out.print(index(0, arr ,  k));
    }
}
