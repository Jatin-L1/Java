package OOPS.Lec_Five.Interfaces;

public class PowerEngine implements  Engine {

    @Override
    public void acc() {
        System.out.println("PoweEngine is accelerating");
        
    }

    @Override
    public void start() {
        System.out.println("PoweEngine starts ");
        
    }

    @Override
    public void stop() {
        System.out.println("PoweEngine stops ");
        
    }

    
}
