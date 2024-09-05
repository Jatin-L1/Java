package Assignments.Recursion;

public class GfGStringLength {
    public static int LENGTH(int i , String str){
        if(i==str.length()){
            return i;
        }


        str.charAt(i);
        return LENGTH(i+1, str);
    }



    public static void main(String[] args) {
        String str = "Jatin Sharma";
        System.out.println(LENGTH(0 , str));
    }
    
}
