package Assignments.Pattern;

import java.util.Scanner;

public class compositepattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int x = sc.nextInt();
        for(int i =1;i<=x;i++){
            for(int j=x-i;j>=1;j--){
                System.out.print("#");

            }
            
            for(int j=0;j<=2*i-2;j++){
                System.out.print((char)(j+65)+" ");
            } 
            System.out.println();
            sc.close();
        }
    }
}
