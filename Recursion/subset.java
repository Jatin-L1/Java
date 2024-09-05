package Recursion;

import java.util.ArrayList;

public class subset {
    static ArrayList<String> arr = new ArrayList<>(); //global 
    public static void printsubset(int i , String str , String ans){
        if(i==str.length()){
            arr.add(ans);
            return;
        }

        printsubset(i+1, str, ans + str.charAt(i)); //take
        printsubset(i+1, str, ans); //not take
    }
    public static void main(String[] args) {
        String str = "Jatin";
        printsubset(0,str,"");
        System.out.println(arr);

    }
}
