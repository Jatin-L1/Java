package Recursion;

import java.util.Scanner;

public class ReverseANumber {
    static int sum = 0;
    public static int rev(int n){

        if(n==0) return 0;

        int remainder = n%10;
        sum = sum*10 + remainder;
        n = n/10;
        rev(n);
        return sum;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(rev(n));
        sc.close();
    }
}
