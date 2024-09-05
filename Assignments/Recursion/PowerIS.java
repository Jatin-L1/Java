package Assignments.Recursion;

public class PowerIS {
    public static boolean Power(int i , int n){
        if (n==1) {
            return true;
        }
        if(i==n){
            return true;
        }
        if (i>n) {
            return false;
        }
         return Power(2*i , n);

    }
    public static void main(String[] args) {

        System.out.print(Power(1 ,8));
    }
}
