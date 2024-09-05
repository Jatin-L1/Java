package Assignments.Pattern;

import java.util.Scanner;

public class alphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n");
        int n = sc.nextInt();
        for(int i = 0;i<=n;i++){
            for(int j=0;j<=i;j++){
                System.out.print((char)(j+65)+" ");
            }
            System.out.println();
            sc.close();
    }
}
    
}
