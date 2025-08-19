public class maxmin {
    public static void num(int i  , int[]arr , int min , int max){
        if(arr.length == i){
            System.out.println("Minimum: " + min);
            System.out.println("Maximum: " + max);
            return;
        }
        if(arr[i]<min){
            min = arr[i];
        }
        if(arr[i]>max){
            max = arr[i];
        }
        num(i+1 , arr , min , max);
    }
    public static void main(String[] args) {
        int [] arr  = {1,2,3,4,5,6,7,8,9,10};

        num(0 , arr , Integer.MAX_VALUE , Integer.MIN_VALUE);

        
    }
}
