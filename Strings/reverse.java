package Strings;

import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder scm = new StringBuilder(sc.nextLine());
        int n = scm.length();
        int i =0 ,j=0;
        while (j<n) {
            if (scm.charAt(j)!=' ') { 
                j++;
            }
            else{
                reverse(scm, i, j-1);
                i = j+1;
                j=i;
            }
            
        }
        reverse(scm, i, j-1);
        System.out.println(scm);

    }
    public static void reverse(StringBuilder scm , int i , int j){
        while (i<=j) {
            char temp = scm.charAt(i);
            scm.setCharAt(i, scm.charAt(j));
            scm.setCharAt(j,temp);
            i++ ; j--;

        }
    }
}
