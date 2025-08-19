import java.util.ArrayList;
import java.util.Scanner;

import Assignments.Arrays.factorial;

public class leader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0 ;i<n;i++ ) arr[i] = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=  0 ;i<n;i++){
            Boolean flag = true;
            for(int j = i +1; j<n;j++){
                if(arr[j]>arr[i]){
                    flag = false;
                    break;
                }
            }
            if(flag) ans.add(arr[i]);
        }
        System.out.println(ans);
    }
}
