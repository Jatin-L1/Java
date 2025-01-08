package Trees;

import java.util.ArrayList;

public class Leetcode102 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(6);
        Node e = new Node(2);
        Node f = new Node(5);
        a.left = b; a.right = c;
        b.left = d ; b.right = e;
        c.right = f;
        int lvl = levels(a);
        for(int i =0;i<=lvl-1;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            nthlevel(a,0,i,arr);
            ans.add(arr);
        }
        System.out.println(ans);
    }
    public static void nthlevel(Node root , int level, int i , ArrayList<Integer> arr ){
        if(root==null) return;
        if(level==i){
            arr.add(root.val);
        }
        nthlevel(root.right, level+1, i, arr);
        nthlevel(root.left, level+1, i, arr);
    }
    public static int levels(Node root){
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
}
