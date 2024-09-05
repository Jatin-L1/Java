package Strings;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class vowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the strimg: ");
        String str = sc.nextLine();
        //vowels
        // int count =0;

        // for(int i =0;i<str.length();i++){
        //     if(str.charAt(i)=='a' || str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u' ){
        //         count++;
        //     }
        // }
        // System.out.print(count);
        //substrings
        int n = str.length();
        for(int i =0;i<n;i++){
            System.out.println(str.substring(i, n));
        }







    }
}
