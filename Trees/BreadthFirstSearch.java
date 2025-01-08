package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
        Node left;
        Node right;
        int val;
        public Node(int val) {
                this.val = val;
        }
}


public class BreadthFirstSearch {
        static int n;
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
                // levelOrderTraversal(a);
                System.out.println();    
                Scanner sc = new Scanner(System.in);
                n = sc.nextInt();
                nthlevel(a, 0);
        }
                
                private static void levelOrderTraversal(Node root) {
                       Queue<Node> q = new LinkedList<>();
                        if(root!=null) q.add(root);
                        while(q.size()>0){
                                Node front = q.remove();
                                System.out.print(front.val+" ");

                                //left to right level order traversal
                                if(front.left!=null) q.add(front.left);
                                if(front.right!=null) q.add(front.right);

                                //right to left level order traversal
                                // if(front.right!=null) q.add(front.right);
                                // if(front.left!=null) q.add(front.left);
                        }
                }
        public static void nthlevel(Node root , int level){
                if(root==null) return;
                if(level==n) System.out.println(root.val);
                nthlevel(root.right, level+1);
                nthlevel(root.left, level+1);
        }
}
