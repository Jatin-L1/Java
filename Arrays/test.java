public class test {
    static class Person{
        private String name;
        private int age;

        Person(){}
        Person(String name , int age){
            this.name = name;
            this.age = age;
        }


        @Override
        public String toString(){
            return "name: " + name + " age: " + age;
        }
    }
    static class Radhika extends Person{
        private int height;

        Radhika(){
            
        }

        Radhika(String name , int age , int height){
            super(name , age);
            this.height = height;
        }

        @Override
        public String toString(){
            return super.toString() +" height"+height;
        }
    }




    public static void main(String[] args) {
        Person pr = new Person();
        Radhika ra = new Radhika("Radhika" , 20 , 4);

    }
}
