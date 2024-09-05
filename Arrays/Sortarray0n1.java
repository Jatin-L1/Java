package Arrays;

import java.util.Scanner;
public class Sortarray0n1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // Arrays.sort(arr);
        // int noofZeros = 0;
        // for(int i=0;i<n;i++){
        //     if(arr[i]==0) noofZeros++;
        // }
        // for(int i=0;i<noofZeros;i++){
        //     arr[i]=0;
        // }
        // for(int i=noofZeros;i<n;i++){
        //     arr[i]=1;
        // }
        int i =0 , j = n-1;
        while (i<j) {
            if (arr[i]==0) {
                i++;
            }
            if (arr[j]==1) {
                j++;
            }
            if (i>j) { break;
                
            }
            if (arr[i]==1 && arr[j]==0) {
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }  
        }
        
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i]+ " ");
        // }
        sc.close();

}
}
