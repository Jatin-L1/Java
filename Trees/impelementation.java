package Trees;

public class impelementation {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int x){
            val = x;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(5);

        display(root);
    }
    public static void display(Node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }
}
