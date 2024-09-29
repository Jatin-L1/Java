package Strings;

import java.util.Scanner;

public class reverseeachstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sbn = new StringBuilder(sc.nextLine());
        int n = sbn.length();
        int i =0 , j=0;
        while (j<n) {
            if(sbn.charAt(j)!=' ') j++;
            else {
                reverse(sbn, i, j-1);
                i=j+1;
                j=i;

            }
        }
        reverse(sbn, i, j-1); //for reversin the last word

        System.out.print(sbn);
        
    }
    public static void reverse(StringBuilder sb , int i , int j){
        while(i<=j){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++ ; j--;
        }
    }

}
