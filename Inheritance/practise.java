package Inheritance;

public class practise {
    static class Person{
        private String name;
        private int age;
        private char gender;

        Person(){

        }

        Person(String name , int age , char gender){
            this.name = name;
            this.age = age;
            this.gender = gender;

        }
        @Override
        public String toString(){
            return "name: "+name+" age: "+age+" gender: "+gender;
        }
    }
    static class employee extends Person{
        int salary;
        employee(){

        }
        employee(String name , int age , char gender , int salary){
            super(name , age , gender);
            this.salary = salary;
        }

        @Override
        public String toString(){
            return super.toString() + " Salary: "+salary;
        }
    }
    public static void main(String[] args) {
        Person per = new Person();
        employee emp = new employee("Jatin" , 19 , 'M' , 1000000);
        System.out.println(emp);
    }
}
