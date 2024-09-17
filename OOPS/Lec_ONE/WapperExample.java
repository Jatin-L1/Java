package OOPS.Lec_ONE;

public class WapperExample {
    public static void main(String[] args) {
       
        // in this num is a object of type integer it is not a primitve type Integer is a wrapper class and it has its own function.
        Integer num = 45; 
        // int a =10;
        // int b = 20;
        // swap(a,b); 
        // when we put int in swap number dosent get swaped because there is no thing like pass by reference in java only pass by value so we need to pass objects in place of variables wo maine karke nhi dikhaya hain isme aur.
        Integer a = 10;
        Integer b = 20;
        swap(a , b);
        System.out.println(a + " " + b);



        // final A jatin = new A("Jatin Sharma");
        // jatin.name = "other name"; // hum ye kar sakte hain 
        // but ye nhi kyunki isme hum re-initialize kar rahe hain hain non-primitive ke liye final allow nhi karta ye sabh
        // jatin = new A("New object");

        A obj;

        for(int i =0;i<1000000000;i++){
            obj = new A("Random name");
        }
    }
    // public static void swap(int a, int b) {
    //     int temp = a;
    //     a = b;
    //     b = temp;
    // }
    public static void swap(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;
    }
    static class A {
        final int num =10;
        String name;
        A(String name) {
            System.out.println("Object is created");
            this.name = name;
        }
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Object is destroyed");
        } // by having the finialize function in class a whenever any object of class a is freed from the memory this function is called Garbage collector. 


        
    }
    
    
    
}
