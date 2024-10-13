package Assignments.Stacks$Queue;

import java.util.Stack;

public class MinStack {
    private static Stack<Integer> first;
    private static Stack<Integer> second;
    public MinStack() {
        first = new Stack<>();
        second = new Stack<>();

    }
    
    public static void push(int val) {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(val);
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        
    }
    
    public static void pop() {
        int count = 0;
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        for(int i =1;i<count ;i++){
            first.push(second.pop());
        }
    }
    
    public static int top() {
        int count = 0;
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        for(int i =1;i<count ;i++){
            first.push(second.pop());
        }
        return second.pop();
    }
    
    public static int getMin() {
        int min = Integer.MAX_VALUE;
        int trial = 0;
        while(!first.isEmpty()){
            trial = first.peek();
            if(trial<min){
                min = first.pop();
            }
        }
        return min;

        
    }
}
