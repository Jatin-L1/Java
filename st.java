import java.util.ArrayList;
import java.util.Collections;

public class st {
    static class KeyValue implements Comparable<KeyValue> {
        // user defined variable so that we can store the key and value
        int key;
        int value;

        KeyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(KeyValue other) {
            return Integer.compare(other.value, this.value);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        ArrayList<KeyValue> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (isProcessed(arr, i)) continue;
            
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            list.add(new KeyValue(arr[i], count));
        }


        Collections.sort(list);

      
        for (KeyValue kv : list) {
            System.out.println("Element: " + kv.key + ", Frequency: " + kv.value);
        }
    }

    private static boolean isProcessed(int[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == arr[index]) {
                return true;
            }
        }
        return false;
    }
}