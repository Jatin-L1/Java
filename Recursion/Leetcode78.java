package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Leetcode78 {
    static ArrayList<String> ans = new ArrayList<>();
    public static void subset(int i , String s , String a){
        int n = s.length();
        if(i==n){
            ans.add(a);
            return;
        }
        subset(i+1, s, a); //not take
        a+=s.charAt(i);
        subset(i+1, s, a); //take



    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ans = new ArrayList<>();
        subset(0, str, "");
        System.out.print(ans);
        sc.close();


    }
    
}
