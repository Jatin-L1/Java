import java.util.Scanner;

public class SumOfDigits {
    static int sum(int n ){
        if(n==0) return 0;

        int remainder = n%10;
        n/=10;
        return remainder + sum(n); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(sum(n));
        sc.close();
        
    }
    
}
