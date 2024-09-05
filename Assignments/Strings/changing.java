package Assignments.Strings;

import java.util.Scanner;

public class changing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        StringBuilder ans = new StringBuilder(str);
        int n = str.length();
        for(int i =0;i<n;i++){
            if(i%2!=0){
                ans.setCharAt(i, '#');
            }
            else ans.setCharAt(i, str.charAt(i));
        }
        System.out.print(ans);
        sc.close();
    }
}
