package OOPS.Lec_two;


// this is a demo to show initialization of static variables
public class staticint {
    static int a =4;
    static int b;

    // will only run once, when the first obj is create i.e when the class is loaded for first time. 
    static {
        System.out.println("I am in static block");
        b=a*5;
    }
    public static void main(String[] args) {
        staticint obj = new staticint();
        System.out.println(staticint.a + " " + staticint.b);

        staticint.b+=3;
        System.out.println(staticint.a + " " + staticint.b);

        staticint obj2 = new staticint();
        System.out.println(staticint.a + " " + staticint.b);
    }
    
}
