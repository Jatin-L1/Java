import java.util.*;

import java.util.Scanner;

public class NumberOfGreater {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of values in a array: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter a number");
        int x = sc.nextInt();
        
        int count=0;
        for(int i=0;i<n;i++){
            if (arr[i]>x) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
