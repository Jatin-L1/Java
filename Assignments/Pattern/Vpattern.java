package Assignments.Pattern;

import java.util.Scanner;

public class Vpattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = sc.nextInt();

        for(int i =1;i<=n;i++){
            for(int j =1;j<=2*n;j++){
               if(i==j || i+j==2*n){
                    System.out.print("*");
               }
               else System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
