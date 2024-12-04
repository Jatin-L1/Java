package Trees;
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
    } 
}
public class NodeOfTress{
    public static void main(String[] args) {
        Node a = new Node(1); //a is a root
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(6);
        Node f = new Node(5);
        a.right = c; a.left = b;
        b.left = d; b.right = e;
        c.right = f;

        System.out.println(b.val);
        System.out.println(a.left.val);
        System.out.println(e.val);
        System.out.println(a.left.right.val);

    }
}