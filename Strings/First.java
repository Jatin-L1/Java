package Strings;

public class First {
    public static void main(String[] args) {
        String s = "My name is jatin sharma";
        String str = "";
        for(int i=0;i<s.length();i++){
            if (i%2==0) {
                str +='a';
            }
            else str += s.charAt(i);
        }
        s=str;
        System.out.println(s);
    }
    
}
