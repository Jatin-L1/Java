public class sumofarray {
    public static void main(String[] args) {
        int[] arr = {5,4,3,10,12,18};
        int n = arr.length;
        int sum =0;
        for(int i =0;i<n;i++){
            sum +=arr[i];
        }
        System.out.println(sum);
    }
}
