package Assignments.Recursion;

public class GfGSumOne_N {
    public static int Sum(int n){
        if(n==1){
            return n;
        }



        return n + Sum(n-1);
    }



    public static void main(String[] args) {
        int n = 100;
       System.err.println( Sum(n));
    }
    
}
