import java.util.Scanner;

public class maxproductsubarrray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0 ; i<n;i++) arr[i]= sc.nextInt();
        int product = Integer.MIN_VALUE;
        for(int i =0 ; i<n;i++){
            int temp = 1;
            for(int j = i ; j<n;j++){
                temp *=arr[j];
                product = Math.max(temp, product);
            }
        }
        System.out.println(product);
    }
    
}
