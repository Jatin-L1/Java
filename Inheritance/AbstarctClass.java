package Inheritance;

import java.util.Scanner;

public class AbstarctClass {
    abstract static  class Shape{
        public abstract Double calculatePerimeter();
    }

    static class Circle extends Shape{

        private double radius;
        

        public Circle(double radius) {
            this.radius = radius;
        }
        public double getRadius(){
            return radius;
        }
        public void setRadius(double radius){
            this.radius = radius;
        }

        @Override
        public Double calculatePerimeter(){
            return 3.14*radius*radius;
        }

    }
    public static class Rectangle extends Shape{
        private double length;
        private double breadth;
        Rectangle(double length , double breadth){
            this.length = length;
            this.breadth = breadth;
        }
        public double getLength(){
            return length;
        }
        public double getBreadth(){
            return breadth;
        }
        public void setLength(double length){
            this.length= length;
        }
        public void setBreadth(double breadth){
            this.breadth = breadth;
        }
        @Override
        public Double calculatePerimeter(){
            return  2*(length+breadth);
        }
    }
    public static class Square extends Shape{
        private double side;
        
        Square(double side) {
            this.side = side;
        }
        public void setSide(double side){
            this.side = side;
        }
        public double getSide(){
            return side;
        }
        @Override
        public Double calculatePerimeter(){
            return side+side;
      }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        switch (n) {
            case 1:
                System.out.println("Radius: ");
                    int radius = sc.nextInt();
                    Circle c = new Circle(radius);
                    System.out.println(c.calculatePerimeter());
                    break;
            case 2:
                System.out.println("Lenght aur breadth dalde: ");
                int length  = sc.nextInt();
                int breadth = sc.nextInt();
                Rectangle rc = new Rectangle(length , breadth);
                System.out.println(rc.calculatePerimeter());
                break;
            case 3:
                System.out.println("Side: ");
                int side = sc.nextInt();
                Square sq = new Square(side);
                System.out.println(sq.calculatePerimeter());
                break;
            default:
                System.out.println("Hogya ");
                break;
        }
    }
    
}
