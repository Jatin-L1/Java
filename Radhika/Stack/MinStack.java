package Radhika.Stack;

import java.util.Stack;

class MinStack {
    private Stack<Integer> st1;
    public MinStack() {
        st1  = new Stack<>();
    }
    
    public void push(int val) {
        st1.push(val);
        
    }
    
    public void pop() {
        st1.pop();
    }
    
    public int top() {
        return st1.peek();
        
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < st1.size(); i++) {
            if (st1.get(i) < min) {
                min = st1.get(i);
            }
        }
        return min;  
    }
}