package Strings;

import java.util.Scanner;

public class toggleChars {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        int n = sb.length();
        for(int i=0;i<n;i++ ){
                char ch = sb.charAt(i);
                int ASCII = (int)ch;
                if (ASCII>=65 && ASCII<=90) {
                    ASCII +=32;
                    ch = (char)ASCII;
                    sb.setCharAt(i, ch);
                }
                else if(ASCII>=97 && ASCII<=122){
                    ASCII -=32;
                    ch = (char)ASCII;
                    sb.setCharAt(i, ch);
                }
        }
        System.out.println(sb);
    }
    
}
