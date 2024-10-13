package Assignments.Stacks$Queue;

import java.util.Stack;

public class DesignAStackWithIncrement {
    class CustomStack {
        Stack<Integer> st;
        int n;
        public CustomStack(int maxSize) {
            st = new Stack<>();
            n = maxSize;
            
        }
        
        public void push(int x) {
            if(st.size()<n){
                st.push(x);
            }
        }
        
        public int pop() {
            if(st.isEmpty()) return -1;
            return st.pop();
            
        }
        
        public void increment(int k, int val) {
            if(st.size()>k){
                Stack<Integer> reverse = new Stack<>();
                while(!st.isEmpty()){
                    reverse.push(st.pop());
                }
                int count =0;
                while(count<k){
                    st.push(reverse.pop()+val);
                }
                while(reverse.isEmpty()){
                    st.push(reverse.pop());
                }

            }
            else{
                Stack<Integer> reverse = new Stack<>();
                while(!st.isEmpty()){
                    reverse.push(st.pop());
                }
                while(!reverse.isEmpty()){
                    st.push(reverse.pop()+val);
                }


            }
        }
    }
}
