import java.util.Scanner;

public class InsertAnElementinArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Scanner sc = new Scanner( System.in);
        int index = sc.nextInt();
        int value = sc.nextInt();
        for(int i =index;i<arr.length-1;i++){
            int val = arr[i];
            arr[i] = val;
        }
        arr[index] = value;
        for ( int ele : arr) {
            System.out.println(ele);
        }
    }
}
