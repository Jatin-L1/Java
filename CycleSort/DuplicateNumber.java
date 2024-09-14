package CycleSort;


public class DuplicateNumber { 
    public static void swap(int a, int b, int[]  arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
        public static int duplicate(int[] arr) {
            while(true){
                int ele = arr[0];
                if(arr[ele]==ele) return ele;
                swap(0, ele,arr);
            }
        }
    


    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(duplicate(arr));

        
    }
}
