package Assignments.Pattern;

import java.util.Scanner;

public class numberbridege {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        for(int i =1;i<=n;i++){
            System.out.print(i);
        }
        for(int i = n-1 ; i>=1;i--){
            System.out.print(i);
        }
        System.out.println();

        for(int i=2;i<=n;i++){
            int nums = 1;
            for(int j = n-i;j>=0;j--){
                System.out.print(nums);
                nums++;
            }
    
            for(int j = 1 ; j<=2*i-3;j++){
               System.out.print(" ");
            }
            for(int j = n-i;j>=0;j--){
                System.out.print(j+1);
            }
            System.out.println();
        }
        

















        // for(int i =1;i<n;i++){
        //     int nums  = 0;
        //     for(int j =n-i;j>1;j--){
        //         System.out.print((nums));
        //         nums++;
        //     }
        //     for(int j = 1 ; j<=2*i+1;j++){
        //         System.out.print(" ");
        //     }
        //     int numstwo  = 0;
        //     for(int j =n-i;j>1;j--){
        //         System.out.print((numstwo));
        //         numstwo++;
        //     }
            
        //     System.out.println();
        // }
        
        sc.close();
        
    }
    }
