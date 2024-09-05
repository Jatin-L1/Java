package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
public class changinarray {
    public static void main(String[] args) {
        int[] arr ={10 , 20 , 30 , 40 , 50};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        System.out.println();
        int [] brr = Arrays.copyOf(arr,arr.length);
        for(int ele:brr){
            System.out.print(ele+" ");
        }
        ArrayList<Integer> zrr = new ArrayList<>(6);
        zrr.size();
        
    }
    public static void change(int [] x){
        x[0]=90;
       
    }
}
