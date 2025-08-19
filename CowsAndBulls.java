import java.util.HashMap;

public class CowsAndBulls {
    public static String getHint(String secret, String guess) {
        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int bulls = 0;
        int cows = 0;

        for(int  i = 0 ;i < secret.length(); i++){
            map1.put(secret.charAt(i) , i);
        }
        for(int  i = 0 ;i < guess.length(); i++){
            map2.put(guess.charAt(i) , i);
        }


        for(char val : map1.keySet()){
            if(map2.containsKey(val)){
                if(map1.get(val)==map2.get(val)) bulls++;
                else cows++;
            }
        }

        sb.append(bulls);
        sb.append('A');
        sb.append(cows);
        sb.append('B');

        return sb.toString();
    }


    public static void main(String[] args) {
        String secret = "1807";
        String  guess = "7810";

        System.out.println(getHint(secret, guess));
    }
}
