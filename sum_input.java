import java.util.Scanner;
public class sum_input {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the 1st number : ");
        int a = sc.nextInt();

        System.out.print("Enter the 2nd number : ");
        int b = sc.nextInt();

        System.out.print("The Sum of the integer is : ");
        System.out.println(a+b);
        sc.close();

    }
}
