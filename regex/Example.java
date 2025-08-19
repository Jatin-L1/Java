package regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Example {
    public static void main(String[] args) {
        Pattern pt = Pattern.compile("a*b*"); // a*b kitne bhi a ayye but lasty main b ayega .a*b* kitne bhi a aur kitne bhi b ho

        //+ jiss char par lagg jaye woh imp ho jata han ki 1 baar jarrur hoina chahiye
        // X? X, once or not at all
        // X{n} x exactly n time
        // X{n,} x at least n times
        // X{n,m} X exactly n but not more than m times

        // X?? X once or not at all

        Matcher matcher = pt.matcher("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");

        boolean matches = matcher.matches();
        System.out.println(matches);

    }
    
}
