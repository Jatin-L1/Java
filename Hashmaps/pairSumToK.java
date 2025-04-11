package Hashmaps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class pairSumToK {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 7, 11, 15, 3, 6));
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        boolean foundPair = false;
        sc.close();

        for (int i = 0; i < arr.size(); i++) {
            int complement = k - arr.get(i);
            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + arr.get(i) + ", " + complement);
                foundPair = true;
                break;
            }
            map.put(arr.get(i), i);
        }

        if (!foundPair) {
            System.out.println("No pair found that sums to " + k);
        }
    }
}
