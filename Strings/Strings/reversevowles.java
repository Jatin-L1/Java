public class reversevowles {
    public static String helper(String s) {
        int n = s.length();
        String ans = "";
        
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while(i<j){
            if(arr[i]!='a' && arr[i]!='e' && arr[i]!='i' && arr[i]!='o' && arr[i]!='u' && arr[i]!='A' && arr[i]!='E' && arr[i]!='I' && arr[i]!='O' && arr[i]!='U'){
                i++;
            }else if(arr[j]!='a' && arr[j]!='e' && arr[j]!='i' && arr[j]!='o' && arr[j]!='u' && arr[j]!='A' && arr[j]!='E' && arr[j]!='I' && arr[j]!='O' && arr[j]!='U'){
                j--;
            }else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(helper(s));
    }
}
