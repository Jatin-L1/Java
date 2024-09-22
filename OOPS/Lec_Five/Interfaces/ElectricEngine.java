package OOPS.Lec_Five.Interfaces;

public class ElectricEngine implements Engine {

    @Override
    public void acc() {
        System.out.println("Electric Engine accelerate");
    }

    @Override
    public void start() {
        System.out.println("Electric Engine Start");
        
    }

    @Override
    public void stop() {
       System.out.println("Electric Engine stops");
        
    }
}
