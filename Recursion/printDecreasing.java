

import java.util.Scanner;


public class printDecreasing {
    public static void print(int n){
        if(n==0) return;
        System.out.println(n);
        print(n-1);
    }

    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        System.out.print("Enter n: ");
        int x = scn.nextInt();
        print(x);
        scn.close();
    }
}
