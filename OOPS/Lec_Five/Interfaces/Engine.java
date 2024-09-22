package OOPS.Lec_Five.Interfaces;

public interface Engine {
    static final int PRICE = 78000;
    void start();
    void stop();
    void acc();

    // Static interface method should always have a body...
    // and they are called by the interface name for this case it is Engine.greeting()
    // static void greeting();
}
