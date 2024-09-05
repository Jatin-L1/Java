package Assignments.Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class vowelSUBSTRING {
    public static int power(int n){
        if(n==0) return 1;
        if(n==1) return 2;
        return 2*power(n-1);
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.nextLine();
        int n = str.length();
        String[] arr = new String[n*(n+1)/2]; 

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                arr[index++] = str.substring(i, j);
            }
        }
        for(String ele:arr){
            System.out.print(ele+" ");
        }
        System.out.println();
        int count =0;
        for(int i =0;i<arr.length;i++){
            boolean onlyVowels = true;
            for(int j =0;j<arr[i].length();j++){
                if(arr[i].charAt(j)!='a'&& arr[i].charAt(j)!='e' && arr[i].charAt(j) !='i' && arr[i].charAt(j)!='o' && arr[i].charAt(j)=='u') {
                    onlyVowels = false;
                    break;
                }
                else{
                    count++;
                }
            }
        }
        System.out.print(count);






        sc.close();
    }
}
