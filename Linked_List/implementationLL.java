package Linked_List;

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


        
    }
    
}
