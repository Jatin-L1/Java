public class binarySearch {
    public static boolean search( int[] arr , int target , int lo , int hi){
        if(lo>hi) return false; 
        int mid  = lo + (hi - lo) / 2;
        if(arr[mid] == target) return true;
        else if(arr[mid] < target) {
            return search(arr, target, mid + 1, hi);
        } else {
            return search(arr, target, lo, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        System.out.println(search(arr, target, 0, arr.length - 1));

    }
}
