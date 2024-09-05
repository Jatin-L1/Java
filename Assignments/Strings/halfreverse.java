package Assignments.Strings;

import java.util.Scanner;

public class halfreverse {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        StringBuilder s = new StringBuilder(sc.nextLine());
        int n = s.length();

        StringBuilder store = new StringBuilder(s);
        int i =n/2;
        int j = n-1;
        while (i<n) {
            store.setCharAt(i,s.charAt(j));
            i++;
            j--;
        }
       System.out.println(store);
       sc.close();
    }


}
