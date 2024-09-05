package Assignments.Pattern;

import java.util.Scanner;

public class specialpattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = sc.nextInt();

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            for(int j =2 ; j<=n+2;j++){
                if(i+j<=2*n-2){
                    System.out.print("#");

                }

            }
            System.out.println();
        }


        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=2*n-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }


        sc.close();
        
    }
}
