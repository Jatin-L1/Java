package Stack;

import java.util.Arrays;

public class ImplementationUsingArray {
    public static class ST{
    //    private int[] arr = new int[5];
    //    private int idx = 0;
    //    void push(int x) {
    //         if(isFull()){
    //             System.out.println("Stack is full");
    //         }
    //         arr[idx++] = x;
       
    //     }
    //     void peek() {
    //         if(idx==0){
    //             System.out.println("The stack is empty");
                
    //         }
    //         else{
    //             System.out.println(arr[idx-1]);
    //         }
             
    //     }
    //     void display(){
    //         for(int i =0;i<idx;i++){
    //             System.out.println(arr[i]+" ");
    //         }
    //     }
    //     void size(){
    //         System.out.println(idx);
    //     }
    //     boolean isEmpty(){
    //         if(idx==0){
    //             System.out.println("Stack is empty");
    //             return true;
    //         }
    //         else if (idx==5) {
    //             System.out.println("Stack in full");
                
    //         }
    //         return false;
    //     }
    //     boolean isFull(){
    //         if(arr.length==idx){
    //             System.out.println("Stack is full");
    //             return true;
    //         }
    //         else{
    //             return false;
    //         }
    //     }
    //     void pop(){
    //         if(isEmpty()){
    //             return;
    //         }
    //         int top = arr[idx-1];
    //         arr[idx-1] = 0;
    //         idx--;

    //     }
    protected int[] data;
    private static final int DEFAULT_SIZE =10;
    int ptr = -1;
    public ST(){
        this(DEFAULT_SIZE);
    }
    public ST(int size) {
        this.data = new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot pop from an empty stack!!");
        }
        // int removed = data[ptr];
        // ptr--;
        // return removed;
        return data[ptr--];
    }
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot peek from an empty stack!!");
        }
        return data[ptr];
    }
    public boolean isFull() {
        return ptr == data.length -1;
    }
    public boolean isEmpty(){
        return ptr ==-1;
    }
    @Override
    public String toString() {
        return Arrays.toString(data) + " "+ ptr ;
    }        
    }
    public static void main(String[] args) throws Exception {
        // ST st = new ST(5);
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.push(3);
        // st.push(3);
        // st.push(3);
        // st.push(3);
        // st.push(3);
        // st.push(4);
        // st.peek();
        // System.out.println(st);
        // System.out.println(st.pop());

        // upar wale main array full hogya hum ab dyanamic array use karenge
        // array ka size double karenge
        DynamicStack st = new DynamicStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(3);
        st.push(3);
        st.push(3);
        st.push(3);
        st.push(3);
        st.push(4);
        System.out.println(st);
        
    }
    
}
