package Assignments.Recursion;
public class GfGTriangle {
    public static void triangle (int[] arr){
        if(arr.length==1){
            for(int ele : arr){
                System.out.println(ele+" ");
            }
            return;
        }
        int[] ans = new int[arr.length-1];

        for(int i =0;i<ans.length;i++){
            ans[i] = arr[i]+arr[i+1];
        }
        triangle(ans);
        for(int ele : ans){
            System.out.print(ele+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int[] arr = {9,8,7,6,5,4,3,2,1};

       triangle(arr);
    }
    
}
