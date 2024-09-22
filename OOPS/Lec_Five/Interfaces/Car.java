package OOPS.Lec_Five.Interfaces;

public class Car implements Engine ,Brake , media {
    // Through interface we can add multiple class multiple inheritance which is not possible in java is possible throgh interfaces

    @Override
    public void acc() {
        System.out.println("Does not need to say anything in this");
        
    }

    @Override
    public void start() {
        
        System.out.println("Batman drives the car in the batman way");
    }

    @Override
    public void stop() {
       System.out.println("Batman does not stop");
        
    }

    @Override
    public void brake() {
        System.out.println("Batman does not need a brake");
        
    }
    

    
}
