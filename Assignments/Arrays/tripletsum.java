package Assignments.Arrays;

import java.util.Scanner;

public class tripletsum {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of array: " );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter a number: ");
        int x = sc.nextInt();
        int count =0;
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = i+2;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==x && arr[i]!=arr[j] &&arr[i]!=arr[k] &&arr[j]!=arr[k]){
                        System.out.println("Triplet found: "+arr[i]+" "+arr[j]+" "+arr[k]);
                        count++;
                    }
                }
            }
        }
        System.out.print("Number of triplet whose sum is = "+x+" are "+count);








        sc.close();
    }
}
