package Assignments.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class plaindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of array: " );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> brr = new ArrayList<>(n);
        for(int i =0;i<n;i++){
            brr.add(i,arr[i]);
        }
        int j = n-1;
        for(int i =0;i<=n/2;i++){
            int temp = brr.get(i);
            brr.set(i, brr.get(j));
            brr.set(j, temp);
            j--;
        }
        boolean isplaindrome = true;
        for(int i =0;i<n;i++){
            if(arr[i]!= brr.get(i)){
                isplaindrome = false;
                break;
        }

        }
          
        if(isplaindrome){
            System.out.println("palindrome");
        }
        else{
            System.out.println("no plaindrome");
        }

        
        sc.close();
}
}
