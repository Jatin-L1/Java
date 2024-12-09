package Trees;

public class InvertBinaryTree {
    public static Node invertree(Node root){
        if(root==null) return root;
        invertree(root.left);
        invertree(root.right);
        Node temp = root.right;
        root.right= root.left;
        root.left = temp;
        return root;
    }
}
