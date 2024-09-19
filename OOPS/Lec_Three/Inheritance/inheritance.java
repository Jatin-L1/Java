package OOPS.Lec_Three.Inheritance;

public class inheritance {
    // private double l; we can use this private in this file only
    double l;
    double h;
    double w;
    
    inheritance() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }
    
    
    inheritance(double side) {
        // super(); sabhi classes ke upar ek class hoti hain joki object class hain isiliye hum super likh pa rahe hain idher
        this.l = side;
        this.h = side;
        this.w = side;
    }
    
    
    inheritance(double l , double h , double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }
    
    inheritance(inheritance old) {
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
    }
    
    public void information(){
        System.out.println("Running the inheritance");

    }


    @Override
    public String toString() {
        return "inheritance [l=" + l + ", h=" + h + ", w=" + w + "]";
    }
    

    
}
