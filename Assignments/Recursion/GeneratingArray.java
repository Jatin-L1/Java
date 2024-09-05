package Assignments.Recursion;

import java.util.ArrayList;

public class GeneratingArray {
    static ArrayList ans = new ArrayList<>(10);
        public static void generate(int[] a ,  int[]b , int i , int j){
            if(ans.size()%2==0){
                System.out.println(ans);
            }
            if(a[i]<b[j] && ans.size()%2==0 && a[i] > (int)ans.get(ans.size()-1)){
                ans.add(a[i]);
                generate(a, b, i+1, j);

            }
            if(b[j]>(int)ans.get(ans.size()-1) && ans.size()%2!=0){
                ans.add(b[j]);
                generate(a, b, i, j+1);
            }

        }



    public static void main(String[] args) {
        ans = new ArrayList<>();
        int[] A = {10,15,25};
        int[] B = {1,5,20,30};
        generate(A, B, 0, 0);

    }
    
}

