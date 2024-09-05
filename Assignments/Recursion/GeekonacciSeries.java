package Assignments.Recursion;

public class GeekonacciSeries {
    public static int Series(int n ){
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 3;
        }
        else if(n==3){
            return 2;
        }
        return Series(n-1)+Series(n-2)+Series(n-3);



    }
    


    public static void main(String[] args) {
        int n = 8;
       System.out.println(Series(8));
    }
}
