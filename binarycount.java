import java.util.ArrayList;
import java.util.Scanner;

public class binarycount {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ;i<=n;i++){
            ans.add(binaryConversion(i));
        }
        Integer[] arr = ans.toArray(new Integer[0]);
        System.out.println(ans);
    }

    private static int binaryConversion(int n) {
        if (n == 0) return 0;
        int count =0 ;
        while(n>0){
            if(n%2==1) count++;
            n = n/2;
        }
        return count;     
    }
    
}
