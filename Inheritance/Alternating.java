package Inheritance;

import java.util.Scanner;

public class Alternating {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean flag = true;
        for(int i = 0 ; i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                flag = false;
                break;
            }
        }
        if(flag==true){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

    }
    
}
