package Trees;
public class symmetricTree {
    public static Node invertree(Node root){
        if(root==null) return root;
        invertree(root.left);
        invertree(root.right);
        Node temp = root.right;
        root.right= root.left;
        root.left = temp;
        return root;
    }
    public static boolean sameTree(Node p , Node q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if (p.val!=q.val) return false;
        return sameTree(p.right, q.right) && sameTree(p.left, q.left);
    }
    public boolean isSymmetric(Node root) {
        invertree(root.left);
        return sameTree(root.left, root.right);

    }
}
