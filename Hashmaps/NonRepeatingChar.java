package Hashmaps;
import java.util.HashMap;
import java.util.Scanner;
public class NonRepeatingChar {
    public static char firstNonRepeating(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(firstNonRepeating(sc.nextLine()));
        sc.close();
    }
}
