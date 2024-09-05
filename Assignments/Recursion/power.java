package Assignments.Recursion;

public class power {
    public static int pow(int n , int a , int i, int multiply){
        if (n==1) {
            return 0 ;
            
        }
        if(multiply==n){
            return i;
        }
        if(multiply>n){
            return 2435;
        }
        return pow(n,a,i+1 , multiply*a);
    }

    public static void main(String[] args) {
        int n = 16;
        int a = 16;
       System.out.println(pow(n,a,0 , 1));
    }
    
}
