package OOPS.Lec_Five;

public abstract class parent {
    // we cannot have final abstract class lazmi hain nha ye tho kyunki jo methods
    // declare hue hain parent main woh uske child ko access karne he padenge

    int age;
    final int VALUE;
  
    
 public parent(int age) {
        this.age = age;
        VALUE = 5685865;

    }

    static void hello(){
        System.out.println("Hey");
        // abstract classes can contain static methods.
    }
    void normal(){
        System.out.println("This is a normal funcation we can make this too....");
        // we can make normal methods and can override them too in son and daughter.
    }

    //Abstract class main abstract methods ki body allowed nhi hoti hain

 abstract void carrer();
 abstract void partner();
    // All the child classes need to overide these methods. Jaruri hain yeh.
    
}
