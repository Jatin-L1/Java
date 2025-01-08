public class Sorting {
    public static void main(String[] args) {
        int[] arr = {1,5,4,3,2};
        int n = arr.length;
        for(int i =0;i<n;i++){
            for(int x = 0;x<n-1-i;x++){
                if(arr[x]>arr[x+1]){
                    int temp =arr[x];
                    arr[x] = arr[x+1];
                    arr[x+1] = temp;
                }
            }
        }
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }
}
