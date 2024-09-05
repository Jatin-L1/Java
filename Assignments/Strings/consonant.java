package Assignments.Strings;

import java.util.Scanner;

public class consonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        int count =0 ;
        int n = str.length();
        for(int i =0;i<n;i++){
            if(str.charAt(i)!='a' && str.charAt(i)!='e' && str.charAt(i)!='i' && str.charAt(i)!='o' && str.charAt(i)!='u'&&str.charAt(i)!='A' && str.charAt(i)!='E' && str.charAt(i)!='I' && str.charAt(i)!='O' && str.charAt(i)!='U'){
                count++;  
            } 

        }
        System.out.print(count);
        sc.close();
    }
}
