package Linked_List;

public class ShallowCopyOfNode {
    public static void main(String[] args) {
        Node a = new Node(100);
        System.out.println(a.val);

        // Node temp = a; // this is a shallow copy of a, ye naya node nhi bana hain.
        Node temp = new Node(100); // this is the deep copy. Ye naya node banna hain 
        System.out.println(a);
        System.out.println(temp.val);
    }
    
}
