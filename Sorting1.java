public class Sorting1 {
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2};
        int n = arr.length;
        int[] ans = new int[arr.length];
        for(int i =0;i<n;i++){
            int max = Integer.MIN_VALUE;
            int k = -1;
            for(int j =0;j<n;j++){
                if(arr[j]>max){
                    max = arr[j];
                    k =j;
                }
            }
            ans[i] = max;
            arr[k] = Integer.MIN_VALUE;
        }
        int i =0;
        int j=n-1;
        while(i<=j){
            int temp =ans[i];
           ans[i] =ans[j];
           ans[j] = temp;
            i++;
            j--;
        }
        for(int ele: ans){
            System.out.print(ele+" ");
        }

    }
}
