package Assignments.Pattern;

import java.util.Scanner;

public class specialpatternone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = sc.nextInt();
        //upper part
        for(int i = 1;i<=n;i++){
            for(int j = 1 ; j<=2*n+1;j++){
                if(i+j==n+1 || j==n && j+i>n &&j+i<=2*n ||j-i==n-1){
                    System.out.print("*");

                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //middle part
        for(int i = 1;i<=2*n;i++){
            System.out.print("*");
        }
        System.out.println();        
        //lower part
        for(int i = 1;i<=n;i++){
            for(int j = 1 ; j<=2*n+1;j++){
                if(i==j || j==n && j+i>n &&j+i<=2*n || i+j==2*n)
                {
                    System.out.print("*");

                }
                else System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();

    }
}
