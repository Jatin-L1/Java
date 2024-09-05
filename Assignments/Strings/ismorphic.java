package Assignments.Strings;

import java.util.Scanner;

public class ismorphic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String dtr = sc.nextLine();
        int[] arr = new int[128];
        boolean check = true;

        for(int i = 0;i<str.length();i++){
            if(arr[(int)(str.charAt(i))] == '\0') arr[(int)(str.charAt(i))] = dtr.charAt(i);
            else{
                if (arr[(int)(str.charAt(i))] != dtr.charAt(i)) {
                    
                    check = false;
                }

            }
        }
        for(int i = 0;i<str.length();i++){
            if(arr[(int)(dtr.charAt(i))] == '\0') arr[(int)(dtr.charAt(i))] = str.charAt(i);
            else{
                if(arr[(int)(dtr.charAt(i))] != str.charAt(i)) check = false;
            }
        }
        if(check){
            System.out.print("Isomorphic");
        }
        else {
            System.out.print("Not Ismorphic");
        }
        

    }
}
