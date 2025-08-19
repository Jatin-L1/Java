// package Stack;

// public class practise {
    
//     public static class Stack{
//         private int top=-1;
//         private int capacity;
//         int[] arr;

//         Stack(int capacity){
//             this.capacity = capacity;
//             arr = new int[capacity];
//         }
//         void push(int val){
//             if(isFull()){
//                 System.out.println("Stack is full");
//                 return;
//             }
//             top++;
//             arr[top] = val;
//         }
//         boolean isFull(){
//              if(top==capacity) return true;
//              return false;
//         }
//         boolean isEmpty(){
//             if(top==-1) return true;
//             return false;
//         }
//         int pop(){
//             if(isEmpty()){
//                 System.out.println("Stack is Empty");
//                 return -1;
//             }
//             int val = arr[top];
//             top--;
//             return val;
//         }

//         void Top(){
//             if(isEmpty()){
//                 System.out.println("Stack is Empty");
//             }
//             else{
//                 System.out.println(arr[top]);
//             }
//         }

//         void display(){
//             if(isEmpty()){
//                 System.out.println("Stack is Empty");
//             }
//             else{
//                 for(int i =top ; i>=0 ; i--){
//                     System.out.print(arr[i]+" ");
//                 }
//                 System.out.println();
//             }
//         }



//     }

//     public static void main(String[] args) {
//         Stack st = new Stack(5);
//         st.push(1);
//         st.push(2);
//         st.push(3);
//         st.display();
//         st.pop();
//         st.display();
//         st.Top();

        
//     }
// }


package Stack;

public class practise {

    public static class Stack {
        private int top = -1;
        private int capacity;
        int[] arr;

        Stack(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
        }

        void push(int val) {
            if (isFull()) {
                System.out.println("Stack is full, increasing the size of stack...");
                resize();  // Dynamically increase size
            }
            arr[++top] = val;
        }

        boolean isFull() {
            return top == capacity - 1;
        }

        void resize() {
            capacity *= 2;
            int[] newArr = new int[capacity];
            for (int i = 0; i <= top; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        boolean isEmpty() {
            return top == -1;
        }

        int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return arr[top--];
        }

        void top() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
            } else {
                System.out.println(arr[top]);
            }
        }

        void display() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
            } else {
                for (int i = top; i >= 0; i--) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack(3);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);  // triggers resize
        st.push(5);  // still works after resize
        st.display(); // 5 4 3 2 1
        st.pop();
        st.display(); // 4 3 2 1
        st.top();     // 4
    }
}

