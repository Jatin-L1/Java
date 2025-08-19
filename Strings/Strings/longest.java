import java.util.HashMap;

public class longest {
    public static String reverse(String str){

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();

    }

    public int longestPalindrome(String[] words) {
        HashMap<String , Integer> map = new HashMap<>();
        int length = 0;
        for(int i =0 ;i<words.length ; i++) map.put(words[i], map.getOrDefault(words[i], 0)+1);

        for(String str : map.keySet()){
            String rev = reverse(str);

            if(map.containsKey(rev)){
                length+=str.length();
                if(!str.equals(rev))length+=rev.length();
                int freq = map.get(str);
                int freq1 = map.get(rev);
                map.put(str, freq-1);
                map.put(rev, freq1-1);
            }
        }



        return length;
        
    }
}
