package Hashmaps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
class Node{
    Node right;
    Node left;
    int val;
    public Node(int val) {
        this.val = val;
    }
    
}
public class pathSum {
    public ArrayList<Integer> copy(ArrayList<Integer> arr){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele : arr){
            ans.add(ele);
        }
        return ans;
    }
    public void helper(Node root , int targetSum,ArrayList<ArrayList<Integer>> ans ,ArrayList<Integer> arr ){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if (targetSum==root.val) {
                arr.add(root.val);
                ans.add(arr);
            }
            return;
        }

        arr.add(root.val);
        ArrayList<Integer> arr1 = copy(arr);
        ArrayList<Integer> arr2 = copy(arr);
        helper(root.left,targetSum-root.val,ans,arr1);
        helper(root.right,targetSum-root.val,ans,arr2);
    }
    public ArrayList<ArrayList<Integer>> pathSum(Node root, int targetSum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        helper(root,targetSum,ans,arr);
        return ans;
    }
    public static void main(String[] args) {
        // pathSum(a , 8);
    }
}
