package Assignments.LinkedList;

import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    Node next;
    Node(int val){
       this.val = val; 
    }
}
class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public boolean palindrome(Node head){
        int length = 0;
        Node temp  = head;
        while(temp!=null){
           temp = temp.next;
            length++;
        }
        temp = head;
        Node a = head;
        Node b = head;
        while(temp!=null){
            for(int i=0;i<length+length/2;i++){
                temp = temp.next;
                b = b.next;
            }
            Node prev = null;
            Node Next = head;
            while(temp!=null){
            Next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = Next;
        }
        while(b!=null){
            if(a.val!=b.val) return false;
            a = a.next;
            b = b.next;
        }

        }
        return true;

    }
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public ListNode middleRight(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode middleLeft(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode middleRightDelete(ListNode head , ListNode node){
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;
    }
    public ListNode DeleteNode(ListNode head , int k ){
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        // for(int i =0;i<k;i++){
        //     fast = fast.next;
        // }
        int i =0;
        while(i<k){
            fast = fast.next;
            i++;
        }
        while (fast!=null) {
            slow = slow.next;
            fast  = fast.next.next;
        }
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;
    }
    public ListNode SwappingNode(ListNode head , int k){
        ListNode slow = head;
        ListNode fast = head;
        // for(int i =0;i<k;i++){
        //     fast = fast.next;
        // }
        int i =0;
        while(i<k){
            fast = fast.next;
            i++;
        }
        while (fast!=null) {
            slow = slow.next;
            fast  = fast.next.next;
        }
        ListNode x = head;
        for(i=0;i<k;i++){
            x = x.next;
        }
        int temp = x.val;
        x.val = slow.val;
        slow.val = temp;
        return head;
    }
    public ListNode intersection(ListNode headA , ListNode headB){
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;
        while (a!=null) {
            a = a.next;
            lenA++;
        }
        while (b!=null) {
            b = b.next;
            lenB++;
        }
        a = headA;
        b= headB;
        if(lenA>lenB){
            for(int i =0;i<lenA-lenB;i++){
                a = a.next;
            }
        }
        else{
            for(int i =0;i<lenB-lenA;i++){
                b =b.next;
            }
        }
        while (b!=null) {
            if(b.val==a.val) return b;
            else{
                b= b.next;
                a =a.next;
            }
        }
        
        return headA;
    }
    public boolean linkedListCycle(ListNode head){
        ListNode slow =head;
        ListNode fast = slow;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode a = head;
        ListNode b = head;
        ListNode c = head;
        ListNode d = head;
        int lenA = 0;
        int lend = 0;
        while(b.val!=left){
            b = b.next;
            lenA++;
        }
        while(c.val!=right){
            c = c.next;
            lend++;
        }
        for(int i=1;i<lenA;i++){
            a = a.next;
        }
        for(int i =0;i<=lend;i++){
            d=d.next;
        }
        System.out.println(a.val);
        System.out.println(b.val);
        System.out.println(c.val);
        System.out.println(d.val);

        a.next = null;
        c.next = null;
        // reversList(b);
        a.next  =c;
        b.next = d;
        return head;
    }
    public ListNode removeaval(ListNode head , int num){

        while(head!=null){
            if(head.next.val==num){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return head;



    }
    public ListNode sortList(ListNode head){
        if(head==null || head.next== null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode firstHalf = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf  = slow.next;
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(slow.next);
        slow.next = null;
        ListNode ans = mergeSortedList(firstHalf , secondHalf);
        return ans;

    }
    public ListNode mergeSortedList(ListNode firstHalf, ListNode secondHalf) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode temp1 = firstHalf;
        ListNode temp2 = secondHalf;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1==null) temp.next = temp2;
        else temp.next = temp1;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;

        ArrayList<ListNode> arr = new ArrayList<>();
        for(int i =0;i<lists.length;i++){
            arr.add(lists[i]);
        }
        if(arr.size()==1) return arr.get(arr.size());
        while(arr.size()!=0){
            ListNode a = arr.remove(arr.size());
            ListNode b = arr.remove(arr.size()-1);
            ListNode c = mergeSortedList(a, b);
            arr.add(c);
        }

        return arr.get(1);
    }
    public ListNode partitonList(ListNode head, int x){
        if(head==null || head.next==null) return head;
        ListNode a = new ListNode();
        ListNode b = new ListNode();
        ListNode temp1 = a;
        ListNode temp2 = b;
        ListNode temp = head;
        while(temp!=head){
            if(temp.val<x){
                temp1.next = temp;
                temp1 = temp1.next;
            }
            else{
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp2.next = null;
        a = a.next;
        b = b.next;
        temp1.next = b;
        if(a==null) return b;
        return a;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode Next = null;
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
            
        }
        return prev;
    }
    public boolean palindrome ( ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode j = reverseList(slow);
        ListNode i = head;
        while(j!=null){
            if(i.val!=j.val) return false;
            i= i.next;
            j = j.next;
        }
        return true;
    }
    public int pairSum(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            temp = temp.next;
            n++;
        }
        ListNode a = head;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<=n/2-1;i++){
            ListNode b = a;
            for(int j =i;j<=n-i-1;j++){
                b = b.next;
            }
            int sum =  a.val + b.val;
            if(sum<max){
                max = sum;
            }
            a =a.next;
        }
        return max;
        
    }
}

public class LinkedList {
    public static void main(String[] args){
        SLL list = new SLL();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.insertAtEnd(70);
        list.insertAtEnd(80);
        list.display();


        }
        

    static ArrayList<Integer> list = new ArrayList<>();
    private static boolean happyNumber(int n, int re) {
        if(list.contains(n)) return false;
        list.add(n);
        re = 0;
        while(n!=0){
            re +=(n%10)*(n%10);
            n /=10;
        }
        if(re==1){
            return true;
        }
        System.out.println(list);
        return happyNumber(re, 0);
    }
    
}