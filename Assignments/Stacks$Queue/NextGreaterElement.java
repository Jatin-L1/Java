package Assignments.Stacks$Queue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st1 = new Stack<>();
        for(int i =nums1.length-1;i>=0;i--){
            st1.push(nums1[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = -1;
        }
        int count = 0;
        while(!st1.isEmpty()){
            int num = st1.pop();
            Stack<Integer> st2 = new Stack<>();
            for(int i =nums2.length-1;i>=0;i--){
                st2.push(nums2[i]);
            }
            while (!st2.isEmpty() && st2.peek()!=num) {
                st2.pop();
            }
            st2.pop();
            while (!st2.isEmpty() && st2.peek()<num) {
                st2.pop();
            }
            if(!st2.isEmpty()){
                ans[count++] = st2.pop();
            }
            else{
                count++;
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int[] arr = {4,1,2};
        int[] brr = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(arr , brr)));

    }
    
}
