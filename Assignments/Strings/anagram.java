package Assignments.Strings;

import java.util.Scanner;

public class anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] arr =new int[26];
        for(int i =0;i<str.length();i++){
            arr[(int)(str.charAt(i))-97]++;
        }
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        int k =0;
        int a = Integer.MIN_VALUE;
        for(int i =0;i<26;i++){
            if(arr[i]>a)
            {
                a = arr[i];
                k = i;  
            } 
        }
        System.out.print(a + " " +(char)(k+97));

}
}
