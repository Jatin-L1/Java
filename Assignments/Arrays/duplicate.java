package Assignments.Arrays;

import java.util.Scanner;

public class duplicate {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements in the array : ");
        int n = sc.nextInt();
        boolean flag = false;

        int [] arr = new int [n];
        int min = Integer.MAX_VALUE;
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
            if(arr[i]<=min){
                min = arr[i];
            }
        }
        int a =0,b=0;
        for(int i = 0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                     a = i ;
                     b = j; 
                     flag = true;
                } 
            }
                }
        if (flag==true) System.out.print("duplicate found at "+ a +"and "+ b);
        else System.out.print("Not found");
        
            
        sc.close();
    }


}
