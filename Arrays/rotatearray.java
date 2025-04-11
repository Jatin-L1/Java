import java.util.*;
import java.util.Scanner;

public class rotatearray {
    public static void main(String[] args) {
        int[] arr = {40,50,60,70,10,20,30};
        int n = arr.length;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter k : ");
        int k = scn.nextInt();
        int[] brr = new int[arr.length];

        if (k<n) {
            for(int i=0;i<n;i++){
                for(int j=1;j<k+1;j++){
                    arr[n-j]=brr[i];
                    System.out.println(arr[n-j]);
                }
        }

        
    }
    }
}