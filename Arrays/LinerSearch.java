package Arrays;
import java.util.Scanner;
public class LinerSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number you want to search: ");
        int n = sc.nextInt();
        System.out.print("Enter the size of array: ");
        int a = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the values in the array: ");
        for(int i=0;i<a;i++){
            arr[i] = sc.nextInt();
          
        }
        boolean flag = false;
        int j =0;
        for(int i=0;i<a;i++){
            if (arr[i]==n) {
                j=i;
                flag = true;
                break;
            }
        }
        if (flag==true) {
            System.out.println("Element Found at"+ j);
        }
        else{
            System.out.println("Elemewnt not found");
        }
        sc.close();
    }
}
