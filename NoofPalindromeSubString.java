public class NoofPalindromeSubString {
    public static void main(String[] args) {
        String input = "abacabcb";
        System.out.println(countPalindromicSubstrings(input));
    }
    public static int countPalindromicSubstrings(String s) {
        int count = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
