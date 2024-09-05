package Arrays;

import java.util.Scanner;

public class DoubletArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the numeber whose sum you want to find: ");
        int a = sc.nextInt();
        

        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (arr[i]+arr[j]==a) {
                    System.out.println("The number are: "+ arr[i] +" "+ arr[j]);    
                }
                break;
                
                
            }
        }






        sc.close();
    }
    
}
