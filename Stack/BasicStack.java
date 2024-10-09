package Stack;

import java.util.Stack;

public class BasicStack {
    public static void recursively(Stack<Integer> st){
        if(st.empty()) return;
        int top = (int) st.pop();
        System.out.println(top);
        recursively(st);
        System.out.println(top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st);
        // System.out.println(st.peek());
        // System.out.println(st);
        // System.out.println(st.pop());
        // System.out.println(st);
        // System.out.println(st.pop());
        // System.out.println(st);
        // System.out.println(st.size());

        //Inserting element at the bottom
        // Stack<Integer> temp = new Stack<>();
        // int x = 23;
        // while(st.size()!=0){
        //     temp.push(st.pop());
        // }
        // st.push(x);
        // while (temp.size()!=0) {
        //     st.push(temp.pop());
        // }
        // System.out.println(st);

        //Interting element at a particular index
        // Stack<Integer> temp = new Stack<>();
        // int idx = 3;
        // int num = 45;

        // while(st.size()>=idx){
        //     temp.push(st.pop());
        // }
        // st.push(45);
        // while(temp.size()!=0){
        //     st.push(temp.pop());
        // }
        // System.out.println(st);
        
        // reversing the stack iteratively;
        // Stack<Integer> temp = new Stack<>();

        // while(st.size()!=0){
        //     temp.push(st.pop());
        // }
        // System.out.println(temp);
        recursively(st);
        // System.out.println(st);

        

    }
}
