public class rotatestrings {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return false;
        if(s.length() != goal.length()) return false;
        String s1 = s+s;
        for(int i =0;i<s.length();i++){
            if(s1.substring(i,i+goal.length()).equals(goal)) return true;
        }
        return false;

    }
}
