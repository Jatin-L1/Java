package Assignments.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class lexographically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.next();
        int n = str.length();
        
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String ans = new String(arr);
        for(char ele : arr){
            System.out.print(ele);
        }
        System.out.println();
        System.out.print(ans);
    }
}
