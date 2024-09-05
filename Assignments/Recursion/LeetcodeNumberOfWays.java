package Assignments.Recursion;

public class LeetcodeNumberOfWays {
    public static int now(int n , int i){

        if(n==0){
            return i;
        }
        if(n%2==0) return now(n/2 , i+1);
        if(n%2!=0) return now(n-1, i+1);
        return 2435;
    }


    public static void main(String[] args) {
        int n = 2;
        System.out.println(now(n,0));
    }
    
}
