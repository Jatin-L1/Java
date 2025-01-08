package Hashmaps;


public class pathsum4 {
    public int helper(Node root , int sum){
        if(root==null) return 0;
        int count =0;
        if(root.val==sum) count++;
        count+=helper(root.right, count- sum) + helper(root.right,count-sum);
        return count;
    }
    public int path(Node root , int sum){
        return helper(root , sum) + helper(root.left , sum) + helper(root.right,sum);
    }

    public static void main(String[] args) {
        
    }
}
