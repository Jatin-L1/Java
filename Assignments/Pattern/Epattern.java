package Assignments.Pattern;

import java.util.Scanner;

public class Epattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        for(int i=1;i<=n+2;i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=1;i<=n-2;i++){
            for(int j=1;j<=2;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=n+2;i++){
            System.out.print("*");
        }
        System.out.println();
        sc.close();
    }
    
}
