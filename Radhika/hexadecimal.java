import java.util.ArrayList;
import java.util.Scanner;

public class hexadecimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        while(n>0){
            arr.add(n%10);
            n =n/10;
        }
        for (int num : numbers) {
            String hex = Integer.toHexString(num).toUpperCase(); 
            System.out.println(num + "\t    " + hex);
        }
    }
}
