package OOPS.Lec_Three.Polymorphism;

public class Main {

    public static void main(String[] args) {
        // Shapes shape = new Shapes();
        // circles circle = new circles();
        // Square square = new Square();

        // what happens if type is of parent class and obeject is of sub class like this
        Shapes shape = new Shapes();
        Shapes circle = new circles();
        Shapes square = new Square();
        
        square.area();



        
    }
    
}
