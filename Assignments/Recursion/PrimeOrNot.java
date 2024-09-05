package Assignments.Recursion;

public class PrimeOrNot {
    public static boolean Prime(int n , int i){
        if (n==i) {
            return true;
            
        }
        if(n%i==0){
            return false;
        }
        return Prime(n, i+1);
    }




    public static void main(String[] args) {
        int n = 11+1;
       System.out.println(Prime(n , 2));
    }
    
}
