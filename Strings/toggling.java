package Strings;

import java.util.Scanner;

public class toggling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter: ");
        String str = sc.nextLine();
        StringBuilder s = new StringBuilder(str);
        int n = str.length();

        for(int i =0;i<n;i++){
            int c = str.charAt(i);
            if((int)(str.charAt(i))<=90 || (int)(str.charAt(i))>=65){
                s.setCharAt(i, (char) Character.toLowerCase(i));
            }
            else {
                s.setCharAt(i, (char) Character.toUpperCase(i));
            }
        }
        System.out.print(s.toString());
    }
}
