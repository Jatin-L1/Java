package Arrays;

class KadanesAlgo{
    public static int algo(int[] arr){
        int res = arr[0];
        int max = arr[0];
        for(int i =0;i<arr.length;i++){
            max = Math.max(max+arr[i] , arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}