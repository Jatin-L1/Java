package Stack;
public class LinkedListImplementation {
    static class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    static class stack{
        Node head = null;
        int size = 0;
        void push(int x){
            Node temp = new Node(x);
            temp.next = null;
             head  = temp;
            size++;

        }
        void size(){
            System.out.println(size);
        }
        void pop(){
            if(head==null){
                System.out.println("Stack is empty");
            }
            int x = head.val;
            System.out.println(x);
            head = head.next;
            size--;
        }
        void peek(){
            if(head==null){
                System.out.println("Stack is empty");
            }
            System.out.println(head.val);
        }
        boolean isEmpty(){
            if(head==null || size==0){
                System.out.println("Stack is empty");
                return true;
            }
            else{
                System.out.println("Stack is not empty");
                return false;
            }
        }
        void display(){
            while(head!=null){
                System.out.println(head.val+" ");
                head= head.next;
            }
        }
        void displayRec(Node head2) {
            if(head2==null) return;
            displayRec(head2.next);
            System.out.println(head2.val);
        }
    }
    public static void main(String[] args) {
        stack st = new stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.display();
        st.size();
    }
}
