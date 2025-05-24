public class reversestring {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reversed = new StringBuilder();
        s = "";
        
        for (int i = words.length - 1; i >= 0; i--) {
            if(words[i]!=" ")reversed.append(words[i]);
        }

        for(int i =0;i<words.length;i++){
            if(words[i]!=" "){
                s += words[i];
                s += " ";
            }

        }
        
        for(String ele : words){
            System.out.println(ele);
        }
        
        return s.trim();
        
    }
}
