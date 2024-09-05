import java.util.Scanner;
public class greatst {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the 1st number : ");
         int a = sc.nextInt();

         System.out.print("Enter the 2nd number : ");
         int b = sc.nextInt();

         System.out.print("Enter the 3rd number : ");
         int c = sc.nextInt();

         if (a>=b && a>=c) {
            System.out.println("a is the greatest");
         }
         else if (b>=a && b>=c) {
            System.out.println("b is the greatest");
         }
         else System.out.println("c is the greatest");

         sc.close();
         
}
}
