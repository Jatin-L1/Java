package Hashmaps;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Leetcode17 {
    public List<String> letterCombinations(String digits) {
        HashMap<String ,String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        map.put("2" , "abc");
        map.put("3" , "def");
        map.put("4" , "ghi");
        map.put("5" ,"jkl");
        map.put("6" , "mno");
        map.put("7", "pqrs");
        map.put("8" , "tuv");
        map.put("9" , "wxyz");

        



        return ans;

    }
}
