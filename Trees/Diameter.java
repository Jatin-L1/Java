package Trees;

public class Diameter {
    public int level (Node root){
        if(root==null) return 0;
        return 1+  Math.max(level(root.right) , level(root.left));
    }
    public int diameterOfBinaryTree(Node root) {
        if(root==null) return 0;
        int myDia = level(root.left) + level(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(myDia , Math.max(left , right));
    }
}
