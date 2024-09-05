import java.util.Scanner;
public class absolute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :");
        int a = sc.nextInt();
        if (a>=0) System.out.println("Your enter number" +a+ "is positive absolute value is = "+a);
        else if (a==0) System.out.println("Your Entered" +a+ "is 0");
        else System.out.println("Your entered number"+a+"is negative absolute value is = " +(-1*a));
        sc.close();
    }
}
