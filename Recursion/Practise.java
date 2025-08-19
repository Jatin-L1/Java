

import java.util.Scanner;

public class Practise {
    public static int fact (int n){
        
        if(n<1) return 1;

        return n*fact(n-1);
    }
    public static int printReverse(int n){
        if(n==1) return 1;
        System.out.println(n);
        return printReverse(n-1);


    }
    public static void printForward(int n){
        if(n==1) {System.out.println("1");return;}
        System.out.println(n);
        printForward(n-1);
    }
    public static void sum(int n , int s){
        // if(n==1) return 1;
        // return n + sum(n-1);
        if(n==0){
            System.out.print(s);
            return;
        }
        sum(n-1,s+n);
        

    }

    public static void power(int a , int b , int s){
        // if(b==0) return 1;
        // return a*power(a , b-1);
        if (b==0) {
            System.out.print(s);
            return;
        }

        power(a,b-1 , s*a);

    }
    public static int fibo(int n){
        if (n<=1) {
            return n;
        }

        return fibo(n-1) + fibo(n-2);
    }
    public static int step(int n){
        if(n==1 || n==2) return n;
        return step(n-1) +step(n-2);
    }
    public static int step_one_three(int n){
        if(n==0) return 1;
        if(n==1 || n==2) return 1;
        return step_one_three(n-1) + step_one_three(n-3);
    }
    public static void maize(int n ,  int m , int s){
        if (n < 0 || m < 0) {
            return;
        }

        if(m==0 && n==0){
            System.out.println(s);
            return;
        }
        if(n==0){
            maize(0,m-1,s+1);
        }
        if (m==0) {
            maize(n-1,0,s+1);
            
        }
        
        maize(n , m-1 , s+1); //rightways
        maize(n-1 , m , s+1); // downways
        // if(n==1||m==1){
        //     return 1;
        // }
        // int rightways = maize(n-1 , m);
        // int downways = maize(n, m-1);
        // return rightways +  downways;


    }

    public static void pip(int n){
        if (n==0) {
            return;
        }
        System.out.print(n);
        pip(n-1);
        System.out.print(n);
        pip(n-1);
        System.out.print(n);
        
    }
    public static void traversing(int i , int[] arr){
        int n = arr.length;
        if (i==n) {
            return;
        }
        System.out.println(arr[i]+" ");
        traversing(i+1, arr);
    }
    public static void traversal(int i , String s){
        int n = s.length();
        if(i==n) return;
        System.out.print(s.charAt(i));
        traversal(i+1, s);
    }
    public static void skip(int i , String s , String a){
        if( i==s.length()){
            System.out.print(a);
            return;

        } 
        if(s.charAt(i)=='a'){
            skip(i+1 , s , a);
        }
        else{
            skip(i+1, s, a+s.charAt(i));
        }
    }


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        // System.out.print("Enter the value of n: ");
        // int n = sc.nextInt();
        // int[] arr =new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i] = sc.nextInt();
        // }
        String s = sc.nextLine();


        // System.out.print("Enter n :");
        // int n= sc.nextInt();
        // printForward(n);
        // power(2,3 , 1);
        // maize(4, 4,0);  
        // pip(5);   
        // traversing(0, arr);
        // traversal(0, s);  
        skip(0, s, "");


        sc.close();
    }
    
}
