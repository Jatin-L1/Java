package OOPS.Lec_Five;

public class Son extends parent {
    public Son(int age){
        super(age);
    }

    @Override
    void carrer() {
       System.out.println("I am Batman");
        
    }

    @Override
    void partner() {
        System.out.println("Batman is always single");
        
    }

    @Override
    void normal() {
        System.out.println("Batman is never normal");
    }
    
}
