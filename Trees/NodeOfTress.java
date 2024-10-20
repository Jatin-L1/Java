package Trees;
class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class NodeOfTress {
    public static void main(String[] args) {
        Node a = new Node(1); //a is the root
        Node b = new Node(41); 
        Node c = new Node(3); 
        Node d = new Node(2); 
        Node e = new Node(6);    
        Node h = new Node(20);    
        Node f = new Node(5); 
        Node g = new Node(10); 
        
        //connections by defeault null hota hain connection 
        a.left = b ; a.right = c;
        b.left = d ; b.right = e;
        c.right = f; c.left = g;
        e.right = h;
        // a.left.right.val = 90; //value bhi change kar sakte hain hum
        // System.out.println(e.val);
        // System.out.println(b.right.val);
        // System.out.println(a.left.right.val);

        display(a);
        System.out.println();
        System.out.println(sum(a));
        System.out.println(product(a));
        System.out.println(Max(a));
        System.out.println(Min(a));
        System.out.println(Size(a));
        System.out.println(levels(a));


    }
    private static void display(Node root){
        if(root==null) return; //base case
        System.out.print(root.val+" ");
        display(root.left); //left subtree
        display(root.right); //right subtree
    }
    private static int sum(Node root){
        if(root==null) return 0;
        int sum = root.val + sum(root.left) + sum(root.right);
        return sum;
    }
    private static int product(Node root){
        if(root==null) return 1;
        int product = root.val * product(root.left) * product(root.right);
        return product;
    }
    private static int productofNonZero(Node root){
        if(root==null) return 1;
        if(root.val==0) return 1;
        int productofNonZero = root.val * productofNonZero(root.left) * productofNonZero(root.right);
        return productofNonZero;
    }
    private static int Max(Node root){
        if(root==null) return Integer.MIN_VALUE;
        int a = root.val , b = Max(root.left) , c = Max(root.left);
        return Math.max(a, Math.max(b, c));
    }
    private static int Min(Node root){
        if(root==null) return Integer.MAX_VALUE;
        int a = root.val , b = Min(root.left) , c = Min(root.left);
        return Math.min(a, Math.min(b, c));
    }
    private static int Size(Node root){
        if(root==null) return 0;
        return 1 + Size(root.left) + Size(root.right);
    }
    private static int levels(Node root){
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }
    
}
