package Recursion;

import java.util.Scanner;

public class ProductOfDigit {
    static int product(int n ){
        if(n%10==n) return n;

        int remainder = n%10;
        n/=10;
        return remainder * product(n); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(product(n));
        sc.close();
        
    }
    
}
