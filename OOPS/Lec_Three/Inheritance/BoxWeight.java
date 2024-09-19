package OOPS.Lec_Three.Inheritance;

public class BoxWeight extends inheritance {
    // ye extends inheritance dalana jaruri hain for the child class to inherit parent class
    double weight;
    public BoxWeight(){
        this.w = -1;
    }
    
    
    public BoxWeight(BoxPrice other){
        this.weight = -1;
    }
    
    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w); // what is this?? it calls the parent class constructor
        // used to initilize values present in parent class
        // if we dont use super default construtor on inheritance is called
        this.weight = weight;
    }
    public BoxWeight(double s , double weight){
        super(s);
        this.weight = weight;
    }

}
