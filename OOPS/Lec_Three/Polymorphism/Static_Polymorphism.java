package OOPS.Lec_Three.Polymorphism;

public class Static_Polymorphism {
    double sum(double a , int b){
        return a+b;
    }
    double sum(int a , int b){
        return a+b;
    }
    double sum(int a , int b,int c){
        return a+b+c;
    }
    public static void main(String[] args) {
        Static_Polymorphism obj = new Static_Polymorphism();
        
        System.out.println(obj.sum(2, 3));
        System.out.println(obj.sum(10, 2, 3));


    }
    
}
