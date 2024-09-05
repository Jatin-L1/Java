package Assignments.Strings;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        StringBuilder s = new StringBuilder(sc.nextLine());
        int n = s.length();

        StringBuilder store = new StringBuilder(s);
        int i =0;
        int j = n-1;
        while (i<n) {
            store.setCharAt(i,s.charAt(j));
            i++;
            j--;
        }
        if(store.toString().equals(s.toString())){
            System.out.print("Palindrome");
        }
        else{
            System.out.print("Not Palindrome");
        }
        sc.close();
    }
}
