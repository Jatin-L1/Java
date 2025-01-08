package HashSets;

import java.util.HashSet;



public class leetcode2744 {
    public String reverse(String str){
        StringBuilder ans = new StringBuilder(str);
        ans.reverse();
        return ans.toString();

    }
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for(int i =0;i<words.length;i++){
            String str = reverse(words[i]);
            if(set.contains(str)){
                count++;
            }
            else set.add(words[i]);
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
