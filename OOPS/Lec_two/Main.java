package OOPS.Lec_two;

import OOPS.Lec_two.Human.human;

public class Main {

    public static void main(String[] args)//main is declared as static method because static means you can use main method without creating the object of the class Main. And it is the very first thing runs when the program starts. 
    // static variables and methods belong to the class not an object.
     {
      human jatin = new human(18 , "Jatin Sharma" , false , 250000);  
      human sambhav = new human(18 , "sambhav das" , false , 250000);  
      human ishaan = new human(19 , "Ishaan Simran Tuli" , true , 250000);  
      human jeeya = new human(20 , "Jeyya Sharma" , false , 250000);  
      System.out.println(jatin.population);
      System.out.println(sambhav.population);
      System.out.println(ishaan.population);
      System.out.println(jeeya.population);

      fun();
    }
    static void fun(){
        // greeting(); 
        //humm isse call nhi kar sakte kyun fun static hain it does not depend on a object it does not belong to an instance
        // greeting depends on instances
        // we cant have a non-static member  inside a static member but ulta possible hain we have have a static member in non-static member.


        // you cannot access non static stuff without refrencing their instances in a static context. Hence here i am refrencing it 
        Main obj = new Main();
        obj.greeting();
    }
    void greeting(){
        System.out.println("hemlo");
    }
    
}
