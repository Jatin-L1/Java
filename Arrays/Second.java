import java.util.*;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of values in a array: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        int max = Integer.MIN_VALUE;
        int SecondMax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if (arr[i]>max) {
                SecondMax=max;
                max =arr[i];
            }
            else if (arr[i]>SecondMax && arr[i]!=max) {
                SecondMax=arr[i];
            }
        }
        System.out.println(max);
        System.out.println(SecondMax);
        sc.close();
    }
    
}
