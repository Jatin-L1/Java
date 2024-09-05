package Assignments.Recursion;

public class FirstUppercaseInString {

    public static char Uppercase(int i , String str){

        int n = str.length();
        if(i>n){
            return 'F';
        }

        if((str.charAt(i))>=65 && (str.charAt(i))<=90) return str.charAt(i);

        else{
            return Uppercase(i+1, str);
        }

    }
    public static void main(String[] args) {
        String str = "jatin sHarma";
       System.out.println(Uppercase(0,str));
    }
}
