public class defangString {
    public String defangIPaddr(String str) {
        int n = str.length();
        String ans = "";

        for(int i =0;i<n;i++){
            if(str.charAt(i)!='.') ans+=str.charAt(i);
            else ans+="[.]";

        }
        return ans;
    }
}
