public class FirstUppercase {
    public char uppercase(String str, int i) {
        if (i == str.length()) return '0'; // Base case: if we reach the end of the string, return '0'
        
        char ch = str.charAt(i);
        if (Character.isUpperCase(ch)) {
            return ch; // Return the first uppercase character found
        }
        
        return uppercase(str, i + 1); // Recursive call to check the next character
    }
    public static void main(String[] args) {
        
    }
}
