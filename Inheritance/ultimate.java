package Inheritance;
public class ultimate {
    abstract class Vehicle{
        protected String brand;
        protected int year;

        Vehicle(){}
        Vehicle(String brand  , int year){
            this.brand =brand;
            this.year = year;
        }

        abstract void displayInfo();

        void start(){
            System.out.println(brand+" is starting.");
        }

        void start(String sound){
            System.out.println(brand+" starts with "+sound+" sound");
        }
    }

    public class Car extends Vehicle{

        private int numberOfDoors;

        Car(){};
        Car(String brand , int year  , int numberofDoors){
            super(brand , year);
            this.numberOfDoors = numberofDoors;
        }

        @Override
        void displayInfo(){
            System.out.println("Brand: "+super.brand);
            System.out.println("Year: "+super.year);
            System.out.println("Number of doors: "+numberOfDoors);
        }

        @Override
        void start(){
            super.start("Brommmmmmmmm.....");
            System.out.println("Car enginer starts smoothly");
        }
        
    }

    public class Truck extends Vehicle{
        private int loadCapacity;

        Truck(){}
        Truck(String brand , int year , int loadCapacity){
            super(brand , year);
            this.loadCapacity = loadCapacity;
        }

        @Override
        void displayInfo(){
            System.out.println("Brand: "+super.brand);
            System.out.println("Year: "+super.year);
            System.out.println("Load Capacity: "+loadCapacity);
        }

        void start(){
            super.start("roar...");
            System.out.println("Truck engines roars");
        }

    }
    public class ElectricCar extends Car{
        private int batteryRange;

        ElectricCar(){}
        ElectricCar(String brand , int year  , int numberofDoors , int batteryRange){
            super(brand , year, numberofDoors);
            this.batteryRange = batteryRange;
        }

        @Override
        void displayInfo(){
            super.displayInfo();
            System.out.println("Battery Range: "+batteryRange);
        }

        @Override
void start() {
    super.start("Zzzzz...");
    System.out.println("Electric car glides silently!");
}
    }
}
