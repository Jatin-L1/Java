package Assignments.Recursion;

public class NumberOfWays {
    static int Count(int n){
        if(n==0) return 1;
        if (n==2) return 2;

        if(n<0) return 0;
        return Count(n-1) + Count(n-2) + Count(n-3);
    }



    public static void main(String[] args) {
        int n = 6;
        System.out.print(Count(n));
    }
}
