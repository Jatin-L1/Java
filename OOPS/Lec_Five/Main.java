package OOPS.Lec_Five;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(18);
        son.carrer();
        son.partner();
        Daughter daughter = new Daughter(20);
        daughter.carrer();
        daughter.partner();


        
        // Parent mom = new Parent(); we cant make object of abstract classes.
        // we also can create abstract constructors.
        // we cant make the abstract static methods too..

        parent.hello(); 
        // parent.normal(); static karna padega normal ko parent main tabhi chalega
    }
    
}
