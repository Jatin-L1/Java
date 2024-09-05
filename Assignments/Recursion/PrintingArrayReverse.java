package Assignments.Recursion;

public class PrintingArrayReverse {
    public static void reverse(int i , int j,  int[] arr){
        if (i==j || i+1==j) {
            for(int ele : arr){
                System.out.print(ele+" ");
            }
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;


         reverse(i+1,j-1 , arr);

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9 ,10};
        reverse(0,arr.length-1 , arr);


    }
}
