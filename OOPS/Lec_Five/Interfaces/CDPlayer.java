package OOPS.Lec_Five.Interfaces;

public class CDPlayer implements media {

    @Override
    public void start() {
        System.out.println("Music starts");
        
    }

    @Override
    public void stop() {
        System.out.println("Music stops");
        
    }

    @Override
    public void acc() {
        System.out.println("Power engine accelerate");
        
    }
    
}
