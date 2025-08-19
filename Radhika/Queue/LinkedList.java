package Radhika.Queue;
public class LinkedList {
    public  static class Node{
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class  Queue {
        private Node head = null;
        private Node tail = null;
        private int size = 0;
        public void add(int val) {
            Node temp = new Node(val);
            if (tail == null) {
                head = tail = temp;
                size++;
                return;
            }
            tail.next = temp;
            tail = temp;
            size++;
        }
        public int remove(){
            if(tail==null){
                System.out.println("Qeueu kahli hain");
                return -1;
            }
            int ele = head.val;

            head = head.next;
            size--;
            return ele;
        }
        public void peek(){
            if(tail==null){
                System.out.println("Qeueu kahli hain");
                return;
            }
            System.out.println(head.val);
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return tail==null;
        }

        
    }
    public static void main(String[] args) {
        Queue q = new Queue();

        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.peek();
        // q.remove();
        // q.peek();
        // System.out.println(q.size());

        System.out.println(q.isEmpty());

        
    }
    
}
