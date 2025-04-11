public class FirrstAndLastOccurenceofPlaindromew {
    static int countPalindrome(String str) {
        int n = str.length();
        int count = 0;
        String[] words = str.split(" ");
        for(int i =0;i<words.length;i++){
            String check = words[i];
            check = check.toLowerCase();
            int x =0 , j = check.length()-1;
            boolean isPlaindrome = true;
            while(x<=j){
                if(check.charAt(x)!=check.charAt(j)){
                    isPlaindrome = false;
                    break;
                }
                    x++;
                    j--;
            
            }
            if(isPlaindrome) count++;
        }
       
        return count;
    }
    static String capitalizeFirstChar(String str)
    {
        String[] ch = str.split(" ");
        StringBuilder s = new StringBuilder(ch[i]);

      for(String word : ch){
            if(word.length()>0){
                char firstChar = Character.toUpperCase(word.charAt(0));
                String capitializedWord = firstChar + word.substring(1);
                s.append(capitializedWord).append(" ");
            }
        }
        return s.toString().trim();

    }
    static String reverseString(String str) {
        int left = 0, right = str.length() - 1;
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            return sb.toString();

        }

    public static void main(String[] args) {
        capitalizeFirstChar("get better at coding");
    }
}
