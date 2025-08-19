package Linked_List;

public class Queue {
    public static class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
        
    }

    public static class queue {
        Node head = null;
        Node tail = null;

        public void add(int val) {
            Node a = new Node(val);
            // Add logic to insert node into the queue as needed
            if (head == null) {
                head = tail = a;
            } else {
                Node temp = head;
                while(temp.next!=tail) temp = temp.next;
                temp.next = a;
                a.next = tail;
            }
        }
    }



    public static void main(String[] args) {
        queue q = new queue();
        q.add(5);

        
    }
    
}
