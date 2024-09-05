package Assignments.Recursion;

import java.util.ArrayList;

public class longestCommonSubstrings {
    static ArrayList<String> brr = new ArrayList<>();
    static ArrayList<String> ans = new ArrayList<>();
    
    public static void printSubsts(int i, String s, String arr) {
        if (i == s.length()) {
            brr.add(arr);
            return;
        }
        printSubsts(i + 1, s, arr);         
        arr += s.charAt(i);                  
        printSubsts(i + 1, s, arr);
    }

    public static void printSubsts_two(int i, String s, String arr) {
        if (i == s.length()) {
            ans.add(arr);
            return;
        }
        printSubsts_two(i + 1, s, arr);     
        arr += s.charAt(i);                  
        printSubsts_two(i + 1, s, arr);
    }

    public static void main(String[] args) {
        String a = "jatin";
        String b = "natin";
        brr = new ArrayList<>();
        ans = new ArrayList<>();
        
        printSubsts(0, a, "");               
        printSubsts_two(0, b, "");           
        
        System.out.println(brr);
        System.out.println(ans);

        String c = "";                     
        
        for (String str1 : brr) {
            for (String str2 : ans) {
                if (str1.equals(str2) && str1.length() > c.length()) {
                    c = str1;
                }
            }
        }

        System.out.println("Longest common substring: " + c);
        System.out.println("Length of the longest common substring: " + c.length());
    }
}
