package Inheritance;

import java.util.Scanner;

public class Encrypted {
    public static int enscryption(int num){
        if(num<100 || num>999){
            System.out.println("Not a valid number");
            return -1;
        }
        else{
            int sum  =0 ;
            while(num>0){
                int rem = num%10;
                sum+=rem;
                num = num/10;
            }
            return sum;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(enscryption(n));
    }
    
}
