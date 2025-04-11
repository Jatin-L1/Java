import java.util.HashMap;
import java.util.Scanner;

public class increasing {
    public int specialArray(int[] arr) {
        int n = arr.length;
        // HashMap<Integer, Integer> map = new HashMap<>();
        int num = 1;
        int count = 0;
        while(num!=count){
            count = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] >= num){
                    count++;
                }
            }
            if(count == num){
                return num;
            }
            num++;
        }
        return -1;
        
    }
}
