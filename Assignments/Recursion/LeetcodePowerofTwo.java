package Assignments.Recursion;

public class LeetcodePowerofTwo {
    public static boolean Power(long n , long i){
        if(n<=0||i>n){
            return false;
        }
        if(n==1 || i==n){
            return true;
        }
        return Power(n, i*4);
    }



    public static void main(String[] args) {
        int n = 15;
        System.out.println(Power(n,1));
    }
    
}
// i used the same logic in leetcode power of 3 and 4 question.
