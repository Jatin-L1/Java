package Radhika.Queue;

public class MyQueue {

    static class  Queue{
        private int[] arr;
        private int CAPACITY = 10;
        private int end = 0;
        public Queue() {
            arr = new int[CAPACITY];
        }
        public void add (int val){
            if(end==CAPACITY-1){
                System.out.println("Bhai queue full hain");
                return;
            }
            arr[end] = val;
            end++;
        }
        public void peek(){
            if(end<0){
                System.out.println("Queue empty hain bhai");
                return;
            }
            System.out.println(arr[0]);
        } 
        public int remove(){
            if(end<0) {
                System.out.println("Queue is empty");
                return -1;
            }
            int ele = arr[0];

            for(int i = 1 ;  i<end;i++){
                arr[i-1] = arr[i];
            }
            arr[end-1] = 0;
            end--;
            return ele;
        }
        public int size(){
            return end;
        }
        public boolean isEmpty(){
            return end<0;
        }
        public boolean isFull(){
            return (end==CAPACITY-1);
        }        
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.peek();
        q.remove();
        q.peek();
        System.out.println(q.size());

    }
    
}
