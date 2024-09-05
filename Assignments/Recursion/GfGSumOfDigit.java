package Assignments.Recursion;

public class GfGSumOfDigit {
    public static int sum( int remainder ,  int n){
        if(n==0){
            return remainder;
        }
        // n = n/10;
        // remainder +=n%10;
        return sum( remainder+n%10, n/10);

    }



    public static void main(String[] args) {
        int n = 2435;
        System.out.println(sum(0,n));
    }
}
