
import java.util.Scanner;

public class product {
    public static int pow(int n , int m ) {
        
        if(m==0) {
            return 1;
        }
        return n * pow(n , m-1);
    }
    public static int pow2(int n , int m ) { //logarithmic method
        
        if(m==0) {
            return 1;
        }
        int ans = pow2(n,m/2);
        if(m%2==0) return ans*ans;
        else return ans*ans*n;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
            System.out.print("Enter n: ");
            int n = sc.nextInt();
            System.out.print("Enter m: ");
            int m = sc.nextInt();
            
            if(n==0 && m==0){
                System.out.print("Not defined");
            }
            else System.out.println(pow2(n,m));
            
            sc.close();
        
    }
}
