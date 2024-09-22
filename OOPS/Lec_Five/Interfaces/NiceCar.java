package OOPS.Lec_Five.Interfaces;

public class NiceCar {
    private Engine engine; // This car has its own private engine of its own.
    private media player = new CDPlayer();


    public NiceCar(){
        engine = new PowerEngine();
    }

    public NiceCar(Engine engine) {
        this.engine = engine;
    }
    public void  start(){
        engine.start();
    }
    public void  stop(){
        engine.stop();
    }
    public void startMusic(){
        player.start();
    }
    public void stopMusic(){
        player.stop();
    }

    public void upgradeEngine(){
        this.engine = new ElectricEngine();

    }

    
    
}
