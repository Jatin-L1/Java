package Linked_List.DoublyLinkedList;
class dNode{
    int val;
    dNode next;
    dNode prev;
    dNode(int val) {
        this.val = val;
    }
}
class DLL{
    dNode head;
    dNode tail;
    int size;
    void display(){
        dNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    void insertAtTail(int val){
        dNode temp  = new dNode(val);
        if(size==0) head = tail = temp;
        else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }
    void insertAthead(int val){
        dNode temp = new dNode(val);
        if(size==0) head = temp = tail;
        else{
            head.prev = temp;
            temp.next = head;
            temp.prev = null;
            head = temp;

        }
        size++;
    }
    void insertAtIndex(int idx , int val){
        if(idx==0){
            insertAthead(val);
            return;
        }
        if(idx==size){
            insertAtTail(val);
            return;
        }
        if(idx>size || idx<0){
            System.out.println("Invalid Index");
            return;
        }
        dNode temp = new dNode(val);
        dNode a = head;
        for(int i =1;i<idx;i++){
            a = a.next;
        }
        dNode b= a.next;
        a.next = temp;
        temp.prev = a;
        temp.next = b;
        b.prev = temp;
        size++;
    }
}

public class implementation {
    public static void print(dNode head){
        dNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void printReverse(dNode tail){
        dNode temp = tail;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void printRandomNode(dNode node){
        dNode temp = node;
        while(temp.prev!=null){
            temp = temp.prev;
        }
        print(temp);
    }
    public static void main(String[] args) {
        // dNode a  =new dNode(10);
        // dNode b  =new dNode(20);
        // dNode c  =new dNode(30);
        // dNode d  =new dNode(40);
        // a.next = b; b.prev = a;
        // b.next = c; c.prev = b;
        // c.next = d; d.prev  =c;
        // print(a);
        // printReverse(d);
        // printRandomNode(c);
        DLL list = new DLL();
        list.display();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.display();
        list.insertAthead(60);
        list.display();
        list.insertAtIndex(2, 80);
        list.display();


    }
    

    
}
