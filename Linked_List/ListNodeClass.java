package Linked_List;
class Node{
    int val;
    Node next; // Yeh agli node ka reference hai 
    public Node(int val) {
        this.val = val;
    }
}

public class ListNodeClass {
    // recursively 
    // public static Node print(Node head){
    //     Node temp = head;
    //     if (temp==null) {
    //        return temp;
            
    //     }
    //     System.out.println(temp.val);            
    //     return print(temp.next);
    // }
    public static void print(Node head){
        Node temp =head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(10); // head
        Node b = new Node(24);
        Node c = new Node(39);
        Node d = new Node(41);
        Node e = new Node(56);
        a.next = b; // This is called linking. 10->20
        b.next = c; // 10->20->30 
        c.next = d; // 10->20->30->40
        d.next = e; // 10->20->30->40->50
        // System.out.println(a.val);
        // System.out.println(a.next);

        
        // print(a);
        // for(int i =1;temp !=null;i++){
        //     System.out.println(temp.val);
        //     temp = temp.next;
        // }
        
        


        System.out.println(a.val);
        System.out.println(a.next.val);
        System.out.println(a.next.next.val);
        System.out.println(a.next.next.next.val);
        System.out.println(a.next.next.next.next.val);

    }
    
}
