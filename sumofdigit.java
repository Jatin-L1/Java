import java.util.Scanner;

public class sumofdigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int variable;
        variable = sc.nextInt();
        while (variable>=10) {
            int sum = 0;
            while(variable!=0){
                int rem =variable%10;
                sum+=rem;
                variable/=10;
            }
            variable = sum;  
        }
        System.out.println(variable);
        sc.close();
    }
}
