import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = sc.nextInt();
        int lo =0,hi=n;
        while (lo<=hi) {
            int mid = (hi-lo)/2 + lo;
            if (mid*mid==n) {
                System.out.println(mid);
                break;
            }
            if (mid*mid>n) {
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }

    }
}
