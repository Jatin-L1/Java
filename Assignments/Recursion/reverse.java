package Assignments.Recursion;

import java.util.Scanner;

public class reverse {

    public static int reverse(int n , int remainder){
        if (n%10==n) {
            remainder = remainder*10 + (n%10);
            return remainder;
            
        }
        remainder = remainder*10 + (n%10);
        n = n/10;
        return reverse(n, remainder);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println(reverse(n, 0));

    }
    
}
