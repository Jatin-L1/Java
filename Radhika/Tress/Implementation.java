package Tress;
public class Implementation {
    static class Node{
        int val ;
        Node left;
        Node right;
        Node(int x){
            this.val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        Node a  = new Node(4);
        Node b  = new Node(2);
        Node c  = new Node(5);
        Node d  = new Node(3);
        Node e  = new Node(0);
        Node f  = new Node(6);
        Node g  = new Node(9);
        Node h  = new Node(8);
        Node i  = new Node(1);
        a.left = b; a.right =c;
        b.left = d ; b.right = null;
        c.left = e ; c.right = f;
        d.left = null; d.right = g;
        g.left = i; g.right = null;
        f.left = h ; f.right = null;
        // postorder(a);
        // System.out.println(max(a));
        //System.out.println(min(a));
        //System.out.println(sum(a));

        //System.out.println(size(a));

        System.out.println(level(a));
        System.out.println(level(a)-1);
    }
    public static int  max(Node root){
        if(root==null) return Integer.MIN_VALUE; 
        return Math.max(root.val , Math.max(max(root.right) , max(root.left)));

    } 

     public static int  min(Node root){
        if(root==null) return Integer.MAX_VALUE; 
        return Math.min(root.val , Math.min(min(root.right) , min(root.left)));

    } 

    public static void preorder(Node root){
        //NLR
        if(root==null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    } 
 public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    } 
	
    public static void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
        
    } 

    public static int sum(Node root){
        if(root==null) return 0;
        int ans  = root.val+ sum(root.left) + sum(root.right);
        return ans;
    }

    public static int prod(Node root){
        if(root==null || root.val==0) return 1;
        return root.val *prod(root.left) *prod(root.right);
        
    }

    public static int size(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int counter =  1 + size(root.left)+size(root.right);
        return counter;
    } 

    public static int level(Node root){
        if(root==null) return 0 ;
        return 1 + Math.max(level(root.right)  , level(root.left));
    }






}
