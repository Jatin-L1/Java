package Assignments.Recursion;

public class GfGPrintOneToN {
    


    public static void main(String[] args) {
        
        print(10);
    }

    public static void print(int n) {
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        print(n-1);
        System.out.print(n+" ");

    }
}
