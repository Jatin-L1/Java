import java.util.HashMap;
public class ShuffleString {
    public String restoreString(String str, int[] indices) {
        HashMap<Integer , Character> map = new HashMap<>();

        for(int i = 0;i<indices.length;i++) map.put(indices[i] , str.charAt(i));

        str = "";

        for(int i =0;i<indices.length;i++) str+=map.get(i);

        return str;

        
    }
}
