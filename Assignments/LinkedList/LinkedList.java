package Assignments.LinkedList;
class Node{
    int val;
    Node next;
    Node(int val){
       this.val = val; 
    }
}
class SLL{
    public Node head;
    private Node tail;
    private int size;
    
    void Size(){
        System.out.println(size);
    }
    void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    } 
    void insertAtEnd(int val){
        Node temp = new Node(val);
        if(head==null){
            head = tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    void insertAtHead(int val){
        Node temp = new Node(val);
        
        if(head == null){
            temp = head = tail;
        }
        else{
            temp.next  = head;
            head = temp;
        }
        size++;
    }
    void insert(int idx , int val){
        if(head==null) insertAtHead(val);
        if(idx==size) insertAtEnd(val);
        if(idx>size) System.out.println("Invalid Index");
        Node temp = new Node(val);
        Node x = head;
        for(int i =1;i<=idx-1;i++){
            x = x.next;
        }
        temp.next = x.next;
        x.next = temp;
        size++;
    }
    void get(int idx) throws Error{
        if(idx==0) {
            System.out.println(head.val);
            return;
        }
        if(idx==size-1) {
            System.out.println(tail.val); 
            return;
        }
        if ( idx>size || idx < 0) {
            throw new Error("Bhai error");
        }
        
        Node x = head;
        for(int i =0;i<idx;i++){
            x = x.next;
        }
        System.out.println(x.val);
    }
    void deleteAtTail(){
        Node x = head;
        for(int i = 0;i<size-2;i++){
            x=x.next;
            // System.out.println(x.val);
        }
        x.next=tail.next;
        x=tail;
        size--;
    }
    void deleteAtHead() throws Error{
        if(head==null){
            throw new Error("Bhai errro");
        }
        head = head.next;
        size--;
    }
    void deleteAtIndex(int idx) throws Error{
        if(idx>size || idx < 0){
            throw new Error("Bhai ek aur error");
        }
        if(idx==size){
            deleteAtTail();
            return;
        }
        if(idx==0){
            deleteAtHead();
            return;
        }
        if(head==null) throw new Error("List is null");
        Node x  =head;
        for(int i = 0;i<idx-1;i++){
            x = x.next;
        }
        if(x.next==tail){
            tail = x;
        }
        x.next = x.next.next;
        
        size--;
    }
    public Node deleteDuplicates(Node head) {
        Node a = head;
        Node b = head;
        while(b!=null){
            if(b.val==a.val) b = b.next;
            else{
                a.next = b;
                a = b;
            }
        }
        a.next = null;
        return head;
        
    }
    // public Node deleteDuplicates_All(Node head) {
    //     Node slow = head;
    //     Node fast = head;
    //     Node temp = head;
    //     while(fast.next!=null){
    //         if(fast.val == temp.val) fast = fast.next;
    //         while(slow.val < fast.val){
    //             slow = slow.next;
    //         }
    //         if(fast.val!= temp.val){
    //             slow = fast.next;
    //             temp = fast;
    //         }
    //     }
    //     slow.next = null;
    //     return head;
        
    // }
    public Node partition(Node head, int x) {
        Node dummy = new Node(100);
        Node a = dummy;
        Node b = dummy;
        Node l = head;
        
        while(l.next!=null){
            if(l.val<x){
                a.next = l.next;
                l = l.next;
            }
            if(l.val>=x){
                b.next = l.next;
                l = l.next;
            }
        }
            a.next = dummy.next;
        return head;
    }
}

public class LinkedList {
    public static void main(String[] args){
        SLL list = new SLL();
        //  Node a = new Node(10);
        //  Node b = new Node(20);
        // System.out.println(a.val);
        // System.out.println(a);
        // System.out.println(a.next);
        
        // a.next = b;
        // System.out.println(a.next);
        // System.out.println(a.next.val +"="+b.val);
    //   list.insertAtEnd(10);
    //   list.insertAtEnd(20);
    //   list.insertAtEnd(30);
    //   list.insertAtEnd(40);
    //   list.display();
    //   list.insertAtHead(56);
    //   list.display();
    //   list.insert(3,69);
    //   list.display();
    //   list.get(4);
    //   list.Size();
    //   list.deleteAtTail();
    //   list.display();
    //   list.deleteAtHead();
    //   list.display();
        // list.deleteAtIndex(3);
        list.insertAtEnd(1);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(2);
        // list.deleteDuplicates_All(list.head);
        list.display();
        list.partition(list.head , 3);
        list.display();
       
       
       
        
        
    }
    
}  