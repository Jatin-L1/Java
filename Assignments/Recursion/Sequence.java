package Assignments.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Sequence {
    static ArrayList list = new ArrayList<>();
    public static void Sequence(int i , int j ,  int[] arr , int[] ans , int k){
        if(i==k){
            list.add(ans);
            return;
        }
        if(arr[j]>ans[i]){
           Sequence(i+1, j+1, arr, ans, k); //not added
           ans[i] = arr[j];
           Sequence(i+1, j+1, arr, ans, k); //added
        }

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter K: ");
        int k = sc.nextInt();
        int[] ans = new int[k];

        int[] arr = new int[n];
        int count =1;
        for(int i =0;i<n;i++){
            arr[i] = count++;
        }
        list = new ArrayList<>();
        Sequence(0, 0 ,arr , ans , k);
        System.out.print(list);
        
    }
    
}
