package OOPS.Lec_Three.Inheritance;

public class Main {
    public static void main(String[] args) {
        inheritance box1 = new inheritance();
        inheritance box2 = new inheritance(box1);
        // these above two object are of inheritance(parent class) they can't access the
        // child values simple nhi haijn bro???
        System.out.println(box1.l + " " + box1.w + " " + box1.h);
        System.out.println(box2);

        BoxWeight box3 = new BoxWeight();
        System.out.println(box3.h + " " + box3.w);
        BoxWeight box4 = new BoxWeight(2, 3, 4, 8);

        inheritance box5 = new BoxWeight(2, 3, 4, 8); //refrencing the parent to child
        // System.out.println(box5.weight); you cannot access this because acccesing of
        // a particular varibale depends on the type of refrence vairable(inheritance)
        // not on the object type(BoxWeight). tho hum l , w , h access kar sakte hain
        // hum weight nhi kar sakte access.





        // there are many variables in both parent and  child classes 
        // you are given access to variables that are in the ref type i.e. BoxWeight
        // hence, you should have access to weight variables
        // this also means that the ones you  are trying to access should be initialised
        // but here , when obj itself is of type parent class, how will you call the constructor of child class
        // that is why error we get

        // BoxWeight box6 = new inheritance(1,2,3); 

        // we cannnot access this because we are refrencing child to parent. we cant have a child refrence variable and a parent object

        BoxPrice box = new BoxPrice(5,6,9); // this is a good example of inheritance and super keyword.
    }

}
