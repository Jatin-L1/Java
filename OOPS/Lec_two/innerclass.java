package OOPS.Lec_two;
public class innerclass {
    // only inner class can be static only inner class can be static because it is itself not dependent on any other class.
    static class test{
        // by declaring it static it does not depend on objects of class innerclass. hum iss object ko outside the class innerclass bhi declare kar sakte hain 
        String name;

        public test(String name) {
            this.name = name;
        }

        // @Override
        // public String toString() {
        //     return name;
        // }
        //without this when you print this  System.out.println(a); a has code is given because java compiler search for to string methods in the class then outside the class agar ye nhi hoga tho woh has code print kar dega 
        
    }
    public static void main(String[] args) {
        test a = new test("Jatin");
        test b = new test("Sambhav");

        System.out.println(a.name);
        System.out.println(b.name);

        System.out.println(a);
    }
    
}
