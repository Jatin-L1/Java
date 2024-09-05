package Assignments.Pattern;

import java.util.Scanner;

public class alphabettwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        for(int i =0 ; i<=n;i++){
            for(int j = n-i ; j>=1;j--){
                System.out.print(" ");
            }
            int num = i;
            for(int j = 1;j<=i;j++){
                System.out.print((char)(num+64));
                num--;
            }
            int numtwo = i;
            for(int j=2;j<=i;j++){
                System.out.print((char)(numtwo+64));
                numtwo--;
            }
            System.out.println();
        }

        sc.close();
    }
}
