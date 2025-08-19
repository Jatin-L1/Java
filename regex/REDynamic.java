package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REDynamic {
    public static void checkStringAgainstRE(String re , String str){
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(str);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }

    public static void main(String[] args) {
        while(true){

            System.out.println("Enter a regualr expresion");
            Scanner sc = new Scanner(System.in);
            String re = sc.nextLine();
    
            System.out.println("Enter the string");
            String str = sc.nextLine();
    
            
            checkStringAgainstRE(re, str);

            System.out.println("Do you want to exit [Y/N]");
            String choice = sc.nextLine();

            if(choice.equalsIgnoreCase("Y")) {
                System.out.println("Dhanwayawad");
                break;
            }
        }

    }
    
}
