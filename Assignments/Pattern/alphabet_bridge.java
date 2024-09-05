package Assignments.Pattern;

import java.util.Scanner;

public class alphabet_bridge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.print("Enter n: ");
            int n = sc.nextInt();
            for(int i=0;i<=n+2;i++){
                System.out.print((char)(i+65));
            }
            System.out.println();
            for(int i =0;i<n;i++){
                int nums  = 0;
                for(int j =n-i;j>1;j--){
                    System.out.print((char)(nums+65));
                    nums++;
                }
                for(int j = 1 ; j<=2*i+1;j++){
                    System.out.print(" ");
                }
                int numstwo  = 0;
                for(int j =n-i;j>1;j--){
                    System.out.print((char)(numstwo+69));
                    numstwo++;
                }

                System.out.println();
            }

            sc.close();
        
    }

}
