public class Char {
    public static String replaceFirstLastChar(String str , String C){
        String[] arr = str.split(" ");
        String ans = "";
        for(int i =0 ;i<arr.length;i++){
            String temp = arr[i];
            StringBuilder sb = new StringBuilder(temp);
            sb.replace(0, 1, C);
            sb.replace(temp.length()-1 , temp.length() , C);
            ans+=sb.toString();
            ans+=" ";
        }
        return ans.trim();

    }
    public static void main(String[] args) {
        String str = "Hello World";
        String C = "*";

        System.out.println(replaceFirstLastChar(str, C));

    }
    
}
