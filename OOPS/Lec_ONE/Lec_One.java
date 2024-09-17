package OOPS.Lec_ONE;
import java.util.Arrays;

public class Lec_One {
    static class student {
        int rno = 23206 ;
        String name = "Jatin" ;
        float  marks = (float) 88.8; 
        // Default Values are declared
        void greeting(){
            System.out.println("My name is "+this.name);
        }
        void changenamme(String newname){
            this.name = newname;
            System.out.println("My name is "+this.name);
        }
        // we need one word to access the object so this was invented.
        // student(){ //in this constructor we did not added any value we declared value by our own
        //   this.rno = 2026;
        //   this.name = "Jatin Sharma";
        //   this.marks = (float)88.8;
        // }
        student(int rno , String name , float marks){ //this is also a constructor in which we added three values 
            this.rno = rno;
            this.name = name;
            this.marks = marks;
        }
        student(student other){ //isme humne constructor ke a ndar object pass kar diya hain 
            this.name = other.name;
            this.rno = other.rno;
            this.marks = 329.4f;
        }
        student(){
            // this is how you call a constructor inside a another constructor
            this(13 , "Default Person" , 100.0f); //internally: 
        }
    }
    public static void main(String[] args) {
        student[] students = new student[5];
        // student Jatin = new student(); //object banaya hain ye and type of jatin is student.
        // Jatin.rno = 2026;
        // Jatin.name = "Jatin Sharma";
        // Jatin.marks = (float)88.8;
        // Declaring the value of Jatin variable by my own


        student Jatin = new student(2027 , "jATIN sHARMA" , 88.4F);
        student sambhav = new student();
        student random = new student(Jatin);
        student random2 = new student();

        sambhav.greeting();


        sambhav.changenamme("sambhav");



        student one = new student();
        student two = one;
        one.name = "Something Something";

        // System.out.println(Jatin.rno);
        // System.out.println(Jatin.name);
        // System.out.println(Jatin.marks);
        System.out.println(two.name);

        
    }
    
}
