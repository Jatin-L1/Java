package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        String[] arr = new String[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.next();
        }
        for(int i =0;i<n;i++){
            Arrays.sort(arr[i]);
        }
        for(String ele: arr){
            System.out.print(ele+" ");
        }










        // String s = "JATIN";
        // String t = "NITAJ";
        // char [] arr = s.toCharArray();
        // char [] brr = t.toCharArray();
        // int n = arr.length;
        // Arrays.sort(arr);
        // Arrays.sort(brr);
        // Boolean ANS = true;
        // for(int i =0;i<n;i++){

        //     if (arr[i]!= brr[i]) {
        //         ANS = false;

        //     }
        // }
        // if(ANS){
        //     System.out.print("The given stringd are anagram");
        // }
        // else{
        //     System.out.print("The given strings are not anagram");
        // }

        
        

    }
    
}
