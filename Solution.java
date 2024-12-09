import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static int[] plusOne(int[] arr) {
        int n = arr.length;
        int  num =0;
        for(int i =0;i<n;i++){
            num = num*10 + arr[i];
        }
        num +=1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(num>0){
            int rem = num%10;
            num = num/10;
            ans.add(rem);
        }
        Collections.reverse(ans);
         int[] result = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

}
