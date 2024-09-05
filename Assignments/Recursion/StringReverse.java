package Assignments.Recursion;

public class StringReverse {
    public static char[] reverse(int i ,int m, char[] str){
        int n = str.length;

        if(i==n/2){
            return str;
        }

        if(i<n/2){
            char temp = str[i];
            str[i]= str[m];
            str[m] = temp;
        }
        return reverse(i+1, m-1, str);  
    }
    public static void main(String[] args) {
        char[] str = {'j','a','t','i','n'};
        int n = str.length;
        System.out.println(reverse(0 ,n-1, str));
    }
}
