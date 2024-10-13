package Assignments.Stacks$Queue;

import java.util.Stack;

public class RemoveOutermostParenthesis {
    public static  String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(st.size()>0){
                    sb.append(s.charAt(i));
                }
                st.push(s.charAt(i));
            }
            else{
                st.pop();
                if(st.size()>0){
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
        
    }
    public static void main(String[] args) {
        String str = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(str));
    }
}
