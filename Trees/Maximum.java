package Trees;

import java.util.*;

class Node{
    int val;
    Node right;
    Node left;
    Node(int val){
        this.val = val;
        this.right = right;
        this.left =left;
    }
    
}
public class Maximum {

    public int Maxi(Node root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.val , Math.max(Maxi(root.right) , Maxi(root.right)));
    }

    public int MaxiWR (Node root){

        int max = Integer.MIN_VALUE;

        Queue<Node> q = new LinkedList();

        if(root!=null) q.add(root);

        while(!q.isEmpty()){
            Node front = q.remove();

            max = Math.max(max, front.val);

            if(front.left!=null) q.add(front.left); 
            if(front.right!=null) q.add(front.right);
        }
        return max;

    }

    public boolean search(Node root , int data){
        if(root==null) return false;
        if(root.val ==data) return true;
        return search(root.left , data) || search(root.right , data);

    }

    public boolean searchWR(Node root , int data){
        if(root==null) return false;

        Queue<Node> q = new LinkedList<>();

        if(root!=null) q.add(root);

        while(!q.isEmpty()){
            Node front = q.remove();

            if(front.val==data) return true;
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
        }
        return false;
    }

    public void insert(Node root , int data){

        Node temp = root;
        while(temp.left!=null) temp=temp.left;
        temp.left = new Node(data);


    }
    public void insertR(Node root , int data){
        if(root.left==null){
            root.left = new Node(data);
            return;
        }
        if(root.left!=null)  insertR(root.left, data);


    }

    
}
