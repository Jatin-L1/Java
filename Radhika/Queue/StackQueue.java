package Radhika.Queue;
import java.util.Stack;
public class StackQueue {

    public static class Queue{

        private Stack<Integer> first = new Stack<>();
        private Stack<Integer> second = new Stack<>();

        public void add(int val){
            first.push(val);
        }
        public int remove(){

            while(!first.isEmpty()){
                second.push(first.pop());
            }
            int ele = second.pop();
            while(!second.isEmpty()){
                first.push(second.pop());
            }
            return ele;
        }
        public void peek(){

            while(!first.isEmpty()){
                second.push(first.pop());
            }
            System.out.println(second.peek());
            while(!second.isEmpty()){
                first.push(second.pop());
            }

        }
        public int  size(){
            return first.size(); 
        }
        public boolean  isEmpty(){
            return first.isEmpty(); 
        }
        public void display(){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            while(!second.isEmpty()){
                System.out.print(second.peek()+" ");
                first.push(second.pop());
            }
        }

    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        q.peek();
        q.display();
    }    
}
