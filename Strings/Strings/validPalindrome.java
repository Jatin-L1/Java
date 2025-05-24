public class validPalindrome {
        public static boolean isPalindrome(String s) {
            if(s==" ") return true;
            int n = s.length();
            String ans = "";
            
            for(int i =0;i<n;i++){
                char ch = s.charAt(i);
    
                if(ch>=65 && ch<=90 || ch>=97 && ch<=122){
                    ans+=Character.toLowerCase(ch);
                }
            }
            int i = 0  , j = n-1;

        while(i<j){
            if(ans.charAt(i)!=ans.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
    
            return true;
    
        }
        public static void main(String[] args) {
            String s = "A man, a plan, a canal: Panama";
            System.out.println(isPalindrome(s));
        }
}

