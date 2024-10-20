package Trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Traversal {
    public static class Pair{
        Node node;
        int level;
        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node a = new Node(1); //a is the root
        Node b = new Node(2); 
        Node c = new Node(3); 
        Node d = new Node(4); 
        Node e = new Node(5);        
        Node f = new Node(6); 
        Node g = new Node(7); 
        Node h = new Node(8); 
        Node i = new Node(9);  
        
        //connections by defeault null hota hain connection 
        a.left = b ; a.right = c;
        b.left = d ; b.right = e;
        c.left = f; c.right = g;
        e.left = h; f.right = i;


        System.out.print("Preorder : ");
        preorder(a);
        System.out.println();
        System.out.print("Inorder : ");
        inorder(a);
        System.out.println();
        System.out.print("Postorder : ");
        postorder(a);
        System.out.println();
        System.out.println("Level Order : ");
        levelOrder(a);
        // System.out.print("Enter n: ");
        // n = sc.nextInt();
        // nthLevel(a,0);

        //level order traversal without using queues
        // for(int k = 0;k<=3;k++){
        //     nthLevel(a, 0 , k);
        //     System.out.println();
        // }
    }
    private static void nthLevel(Node root ,  int level , int lvl){
        if(root==null) return; //base case
        if(level==lvl) System.out.print(root.val+" ");
        nthLevel(root.left , level+1 , lvl); //left subtree
        nthLevel(root.right , level+1 , lvl); //right subtree
    }
    private static void levelOrder(Node root){
        // Queue<Node> q = new LinkedList<>();
        // if(root!=null) q.add(root);
        // while(q.size()>0){
        //     Node front = q.remove();
        //     System.out.print(front.val+" ");
        //     if(front.left!=null) q.add(front.left);
        //     if(front.right!=null) q.add(front.right);
        // }

        //level wise printing;
        int prevlevel = 0;
        Queue<Pair> q = new LinkedList<>();
        if(root!=null) q.add(new Pair(root , 0));
        while(q.size()>0){
            Pair front = q.remove();
            Node temp = front.node;
            int lvl = front.level;
            if(lvl!=prevlevel){
                System.out.println();
                prevlevel++;
            }
            System.out.print(temp.val+" ");
            if(temp.left!=null) q.add(new Pair(temp.left , lvl+1));
            if(temp.right!=null) q.add(new Pair(temp.right , lvl+1));

        }
    }

    private static void preorder(Node root){
        if(root==null) return; //base case
        System.out.print(root.val+" ");
        preorder(root.left); //left subtree
        preorder(root.right); //right subtree
    }
    private static void inorder(Node root){
        if(root==null) return; //base case
        inorder(root.left); //left subtree
        System.out.print(root.val+" ");
        inorder(root.right); //right subtree
    }
    private static void postorder(Node root){
        if(root==null) return; //base case
        postorder(root.left); //left subtree
        postorder(root.right); //right subtree
        System.out.print(root.val+" ");
    }
}
