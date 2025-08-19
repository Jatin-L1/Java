import java.util.HashSet;
import java.util.Scanner;

public class BinaryVille {
    public static boolean binaray(String s , int k){
        HashSet<String> set = new HashSet<>();

        for(int i =0 ;i<s.length()-k;i++){
            String str = s.substring(i, i+k);
            set.add(str);
        }
        return (set.size()==(int)(Math.pow(2, k)));

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(binaray(str, 2));
    }
}
