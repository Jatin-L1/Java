package OOPS.Lec_two;
public class Human {

   public static class human {
        int age;
        String name;
        boolean married;
        int salary;
        static long population; //static isliye because it is common to everyone
        static void message(){
            System.out.println("Hello world");
            // System.out.println(this.age); //cant use this over here 
        }
        public human(int age, String name, boolean married, int salary) {
            this.age = age;
            this.name = name;
            this.married = married;
            this.salary = salary;
            human.population +=1; //class.variable_name this is the better way or right way
        }

    }
    
}
