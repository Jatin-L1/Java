package Assignments.Recursion;

public class odd {
    static int SumOdd(int a , int b){
        if(a==b){
            return a;
        }

        if(a%2!=0){
            return a + SumOdd(a+1, b);
        }
        else {return SumOdd(a+1, b);}


    }
    public static void main(String[] args) {
        System.out.print(SumOdd(1,7));
    }
    
}
