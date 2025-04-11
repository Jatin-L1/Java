import java.util.*;

import java.util.Scanner;

public class Leetcode121 {
    public static int maxProfit(int[] arr) {
        int n = arr.length;
        int max =0;

        // int buy = Integer.MAX_VALUE;
        // int sell = Integer.MIN_VALUE;
        // int buyIndex =0;
        // int hi = 0;
        // for( int j =0;j<n-1;j++){
        //     if(arr[j]<buy)
        //     {
        //         buy  =arr[j] ;
        //         buyIndex =j;
        //     } 
        // }
        // for(int i = buyIndex+1;i<n;i++){
        //     if(arr[i]>sell) sell =  arr[i];
        //     hi =i;
            
        // }
        // if(sell-buy<0) return 0;
        // if(hi>buyIndex) return sell - buy;


        // System.out.println(buy);
        // System.out.println(sell);
        // return 0;

        //brute force but time limit will exceed 
        // for(int i =0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         int profit = arr[j]-arr[i];
        //         if(profit>max){
        //             max  = profit;
        //         }
        //     }
        // }
        // if(max>0) return max;
        // return 0;
        
        // Auxillary Array

        return 0;


        
        
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int [] aux = new int[arr.length];
        for(int i =0;i<n;i++){
            for(int j =n-1;j>=0;j--){
                aux[i] = Math.max(arr[j], arr[j-1]);
            }

        }
        for(int ele : aux){
            System.out.print(ele);
        }

        System.out.print(maxProfit(arr));
    }
    
}
