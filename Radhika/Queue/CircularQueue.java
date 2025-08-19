// // package Radhika.Queue;
// // public class CircularQueue {

// //     static class Queue {
// //         private int[] arr;
// //         private int CAPACITY = 10;
// //         private int front = 0;
// //         private int rear = 0;
// //         private int size = 0;

// //         public Queue() {
// //             arr = new int[CAPACITY];
// //         }

// //         public void add(int val) {
// //             if (isFull()) {
// //                 System.out.println("Bhai queue full hain");
// //                 return;
// //             }
// //             arr[rear] = val;
// //             rear = (rear + 1) % CAPACITY;
// //             size++;
// //         }

// //         public void peek() {
// //             if (isEmpty()) {
// //                 System.out.println("Queue empty hain bhai");
// //                 return;
// //             }
// //             System.out.println(arr[front]);
// //         }

// //         public int remove() {
// //             if (isEmpty()) {
// //                 System.out.println("Queue is empty");
// //                 return -1;
// //             }
// //             int ele = arr[front];
// //             front = (front + 1) % CAPACITY;
// //             size--;
// //             return ele;
// //         }

// //         public int size() {
// //             return size;
// //         }

// //         public boolean isEmpty() {
// //             return size == 0;
// //         }

// //         public boolean isFull() {
// //             return size == CAPACITY;
// //         }
// //     }

// //     public static void main(String[] args) {
// //         Queue q = new Queue();
// //         q.add(1);
// //         q.add(2);
// //         q.add(3);
// //         q.add(4);
// //         q.peek();         // should print 1
// //         q.remove();       // remove 1
// //         q.peek();         // should print 2
// //         System.out.println(q.size());  // should print 3
// //     }
// // }
// package Radhika.Queue;
// public class CircularQueue {

//     static class  Queue{
//         private int[] arr;
//         private int CAPACITY = 10;
//         private int start = 0;
//         private int end = 0;
//         private int size = 0;
//         public Queue() {
//             arr = new int[CAPACITY];
//         }
//         public void add (int val){
//             if(end==CAPACITY){
//                 System.out.println("Bhai queue full hain");
//                 return;
//             }
//             arr[end] = val;
//             end = (end+1)%CAPACITY;
//             size++;
//         }
//         public void peek(){
//             if(end<0){
//                 System.out.println("Queue empty hain bhai");
//                 return;
//             }
//             System.out.println(arr[0]);
//         } 
//         public int remove(){
//             if(end<0) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }
//             int ele = arr[start];
//             start = (start+1)%CAPACITY;
//             size--;

//             return ele;
//         }
//         public int size(){
//             return size;
//         }
//         public boolean isEmpty(){
//             return end<0;
//         }
//         public boolean isFull(){
//             return (end==CAPACITY-1);
//         } 
//         public void display(){
//             for(int ele:arr){
//                 System.out.print(ele + " ");
//             }
//             System.out.println();
//         }      
//     }
//     public static void main(String[] args) {
//         Queue q = new Queue();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         q.add(1);
//         q.add(2);
//         q.display();
//         q.add(5);
//         q.display();
//     }
// }
package Radhika.Queue;

public class CircularQueue {
    
    static class queue{
        private int[] arr;
        private int capacity=10;
        private int end =0;
        private  int start =0;
        private int size=0;

        public queue(){
            arr= new int[capacity];           
        }

    void add(int val){
        if(end ==capacity){
            System.out.println("que is full");
            return;
        }
        arr[end]=val;
        end=(++end)%capacity;
        size++;
    }

    public int peek(){
        if(end <= 0){
            System.out.println("que is empty");
            return -1;
        }
        return arr[0];
    }

   public int remove() {
        if (end <= 0) {
            System.out.println("que is empty");
            return -1;
        }
        start = (start + 1) % capacity;
        start = (start +1  - capacity) % capacity; // to move backewars
        size--;
        return arr[start];
    
    }

    public int size(){
        return end;
    }

    public boolean isEmpty(){
        return end<0;
    }

    public boolean  isFull(){
        return end==capacity-1;
    }

    public void display(){
        for(int ele:arr){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        q.display();
        q.add(11);
        q.display();   
    }
}
