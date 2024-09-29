package Linked_List;
class Node{
    int val;
    Node next; // Yeh agli node ka reference hai 
    public Node(int val) {
        this.val = val;
    }
}
 class SLL{
    //user  defined data structure
    private Node head;
    private Node tail;
    private int size;
    void insertAtTail(int val) {
        Node temp = new Node(val);
        if(head==null){
            head = temp;
            tail = temp;
            // head = temp = tail;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
        size++; 
    }
    void insertAtHead(int val) {
        Node temp = new Node(val);
        if(head==null){
            head = temp;
            tail = temp;
            // head = temp = tail;
        }
        else{
            temp.next = head;
            head = temp;
        }
        size++; 
    }
    void display(){
            Node temp =head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    void size(){
        System.out.println(size);
    }
    void insert(int idx , int val){
        if(idx==0){
            insertAtHead(val);
            return;
        }
        if(idx==size){
            insertAtTail(val);
            return;
        }
        if(idx>size){
            System.out.println("Invalid Index");
            return;
        }
    
        Node temp = new Node(val);
        Node x = head;
        for(int i =1;i<=idx-1;i++){
            x = x.next;
        }
        //insertion
        temp.next =  x.next;
        x.next = temp;
        size++;
    }
    void get(int idx) throws Error{
        if(idx==size-1){
            System.out.println(tail.val);
        }
        if(idx>=size || idx<0){
           throw new Error("Bhai Error");
        }
        Node x = head;
        for(int i =1;i<=idx;i++){
            x = x.next;
            if(i==idx) System.out.println(x.val);
        }
    
    }
    void set(int idx , int val){
        // if(idx==size-1){
        //     tail.val = val;
        // } hatta bhi sakte hain isse hum.
        if(idx>=size || idx<0){
           throw new Error("Bhai Error");
        }
        Node x = head;
        for(int i =1;i<=idx;i++){
            x = x.next;
        }
        x.val  =val;
    
    }
    void deleteAtHead() throws Error{
        if(head==null) throw new Error("List is null");
        head = head.next;
        size--;
    }
    void deleteAtTail() throws Error{
        if (head == null) {
            throw new Error("List is empty. Nothing to delete.");
        }
    
        if (size == 1) { 
            head = null;
            tail = null;
        }
        else{
        Node temp = head;
        for(int i =1 ; i<=size-2;i++){
            temp = temp.next;
        }
        tail =  temp;
        temp.next = null;
    }
        size--;
    }
    void delete(int idx) throws Error{
        if(idx==0){
            deleteAtHead();
            return;
        }
        if(head==null) throw new Error("List is null");
        if(idx<0 || idx>=size) throw new Error("Invalid Index");
        Node temp = head;
        for(int i =1;i<=idx-1;i++){
            temp = temp.next;
        }
        if(temp.next==tail){
            tail = temp;
            // deletion ke sath sath tail change ho jaye uske liye hain ye 
        }
        temp.next = temp.next.next; // ye deletion hain
        size--;

    }
}
public class implementationLL {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.size();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.size();
        list.display();
        list.insertAtHead(133);
        list.display();
        list.insert(2, 100);
        list.display();
        list.insert(4, 80);
        list.display();
        // list.get(100);
        list.set(2, 122);
        list.display();
        list.deleteAtHead();
        list.display();
        list.size();
        list.deleteAtTail();
        list.display();
        list.size();
        list.delete(3);
        list.display();
        list.size();
        list.delete(3);


        
    }
    
}
