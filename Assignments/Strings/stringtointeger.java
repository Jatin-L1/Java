package Assignments.Strings;

import java.util.Scanner;

public class stringtointeger {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Bhai 1-10 ke bich ain he daliyo: ");
        String s = sc.nextLine();
        int n =0;
        for(int i=0;i<s.length();i++) {
             n = ((int)(s.charAt(i)) - 48);
        }
            System.out.print(n);
            sc.close();
    }
}