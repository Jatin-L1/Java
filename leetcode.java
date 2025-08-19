import java.util.HashMap;

public class leetcode {
    public char findTheDifference(String s, String t) {
        HashMap<Character , Integer> smap = new HashMap<>();
        HashMap<Character , Integer> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (char c : tmap.keySet()) {
            if (!smap.containsKey(c) || smap.get(c) != tmap.get(c)) {
                return c;
            }
        }
        return  ' ';
    }
    

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) return false;
            }
            return true;
        } else if (Character.isLowerCase(word.charAt(0)) && Character.isLowerCase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
            return true;
        } else {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
            return true;
        }
        
    }
    public int lengthAfterTransformations(String s, int t) {
        int n = s.length();
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ;i<n;i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        while(t>0){
            String temp = "";
            for(char c : map.keySet()){
                for(int i = 0 ; i<map.get(c);i++){
                    if(c!='z')temp += (char)(c+1);
                    else temp+= "ab";
                }
            }
            s = temp;
            t--;
        }
        return s.length();  
    }
}
