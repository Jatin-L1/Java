public class goodSubstrings {
    public static int longestGoodSubstring(String s) {
        int maxLength = 0;
        int currentLength = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }
        return maxLength;
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        String s = "aecdiuoaeocda";
        System.out.println(longestGoodSubstring(s));
    }
}
