package Trees;

import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
    } 
}

public class practise {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(6);
        Node e = new Node(2);
        Node f = new Node(5);
        a.left = b; a.right = c;
        b.left = d ; b.right = e;
        c.right = f;
        // display(a);
        // System.out.println(sum(a));
        // System.out.println(product(a));
        // System.out.println(max(a));
        // System.out.println(min(a));
        // System.out.println(size(a));
        // System.out.println(levels(a));
        invertTree(a);
        display(a);
    }
    public static void display(Node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }
    public static int sum(Node root){
        if(root==null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    public static int product(Node root){
        if(root==null) return 1;
        return root.val * product(root.left) * product(root.right);
    }
    public static int max(Node root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.val , Math.max(max(root.left) , max(root.right)));
    }
    public static int min(Node root){
        if(root==null) return Integer.MAX_VALUE;
        return Math.min(root.val , Math.min(min(root.left) , min(root.right)));
    }
    public static int size(Node root){
        if(root==null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
    public static int levels(Node root){
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left)  ,levels(root.right));
    }
    public static Node invertTree(Node root){
        if(root==null) return root;
        invertTree(root.left);
        invertTree(root.right);
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }
    public static boolean sameTree(Node a , Node b){
        if(a.val!=b.val) return false;
        sameTree(a.left , b.left);
        sameTree(a.right , b.right);
        return true;
    }
    public boolean hasPath(Node root , int targetSum){
        if(root==null) return false;
        if(root.right==null && root.left==null && targetSum==root.val) return true;
        return hasPath(root.left , targetSum-root.val) || hasPath(root.right, targetSum-root.val);
    }
    
}
