import java.util.Scanner;

public class missingNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long s=(n)*(n+1)/2;
        long sum=0;
        for (long i=1;i<n;i++){
            sum+=sc.nextLong();
        }
        // System.out.println(sum);
        // System.out.println(s);
        System.out.println(s-sum);
    }
}
