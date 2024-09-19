package OOPS.Lec_Three.Polymorphism;

public class circles extends Shapes {


    //this will run when obj of circle is created
    // hence it is overriding the parent method
    @Override // check hain sirf ye ki method overidden hain ki nhi annotation khete hian inhe
    
    void area(){
        System.out.println("Area is pie * r * r");
    }
    
}
