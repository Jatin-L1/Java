package Trees;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return Travese(root , p , q );
    }

    private TreeNode Travese(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        TreeNode check = root;
        if(root.val==p.val || root.val == q.val) return root;
        Travese(root.left, p, q);
        Travese(root.right, p, q);
        return root;

    }
}
