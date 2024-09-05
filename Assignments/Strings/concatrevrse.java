package Assignments.Strings;

import java.util.Scanner;

public class concatrevrse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        StringBuilder reverse = new StringBuilder(str);
        int n = str.length();
        int i =0 , j=n-1;
        while (i<n) {
            reverse.setCharAt(i , str.charAt(j) );
            i++;
            j--;
            
        }
        System.out.print(str.concat(reverse.toString()));
        sc.close();
    }
}
