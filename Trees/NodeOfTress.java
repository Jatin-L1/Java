package Trees;

import Sorting.descendingbubblesort;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class NodeOfTress {
    public static void main(String[] args) {
        Node a = new Node(1); // a is a root
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(6);
        Node f = new Node(5);
        Node g = new Node(10);
        Node h = new Node(20);
        a.right = c;
        a.left = b;
        b.left = d;
        b.right = e;
        c.right = f;
        c.left = g;
        e.right = h;

        // display(a);
        System.out.println(Sum(a));
        System.out.println(max(a));
        System.out.println(min(a));
        System.out.println(size(a));
        System.out.println(levels(a));
        System.out.println(height(a));

        // System.out.println(b.val);
        // System.out.println(a.left.val);
        // System.out.println(e.val);
        // System.out.println(a.left.right.val);
    }

    public static void display(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        display(root.right);
        display(root.left);
    }

    public static int product(Node root){
        if (root == null) return 1;
        int ans = root.val * product(root.right) * product(root.left);
        return ans;
    }
    public static int productNonZero(Node root){
        if (root == null || root.val==0) return 1;
        int ans = root.val * product(root.right) * product(root.left);
        return ans;
    }
    public static int Sum(Node root) {
        if (root == null) return 0;
        int sum = root.val + Sum(root.left) + Sum(root.right);
        return sum;
    }
    public static int max (Node root){
        if (root==null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }
    public static int min (Node root){
        if (root==null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(min(root.left), min(root.right)));
    }
    public static int size(Node root){
        if (root==null) return 0;
        return 1 + size(root.left) + size(root.right);
        
    }
    public static int levels(Node root){
        if (root==null) return 0;
        return 1 + Math.max(levels(root.right) , levels(root.left));
    }
    public static int height(Node root){
        return levels(root)-1;
    }
}