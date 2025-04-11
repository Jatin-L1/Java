import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.print(n+" ");
        while(n>0 &&n!=1){
            if(n%2==0){
                n = n/2;
                System.out.print(n+" ");
            }
            else{
                // System.out.println("hello");
                n=n*3+1;
                System.out.print(n+" ");
            }
        }

    }
}
