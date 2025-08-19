import java.util.Arrays;

public class TraingleSum {
    public static void sum(int[] arr){
        int n = arr.length;
        if(n==1){
            System.out.println(Arrays.toString(arr));
            return;
        }
        int[] newArr = new int[n-1];
        for(int i = 0; i < n - 1; i++){
            newArr[i] = arr[i] + arr[i + 1];
        }
        sum(newArr);
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        sum(arr);
        





    }
}
