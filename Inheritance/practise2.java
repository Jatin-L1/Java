package Inheritance;

public class practise2 {
    static class Person{
        private String name;
        private int age;

        Person(){}

        Person(String name ,int age){
            this.name = name;
            this.age = age;
        }

        void introduce(){
            System.out.println("My name is "+name+" and my age is "+age);
        }
    }
    static class employee extends Person{
        private int salary;

        employee(){};

        employee(String name ,int age , int salary){
            super(name , age);
            this.salary = salary;
        }

        @Override
        void introduce(){
            super.introduce();
            System.out.println(" and my salary is "+salary);

        }

    }
    static class Manager extends employee{
        private int teamSize;

        public Manager() {
        }

        public Manager(String name, int age, int salary, int teamSize) {
            super(name, age, salary);
            this.teamSize = teamSize;
        }

        @Override
        void introduce(){
            super.introduce();
            System.out.println(". We have a team size of "+teamSize);
        }
    }

    public static void main(String[] args) {
        Manager jatin = new Manager("Jatin" , 18 , 300000 , 4);
        jatin.introduce();
    }
}
