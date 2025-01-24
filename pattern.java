import java.lang.reflect.Array;
import java.util.*;
public class pattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        while(n!=0){
            int rem =n%10;
            n=n/10;
            arr.add(rem);
        }
        int sumO = 0;
        int sumE = 0;
        for(int i =0;i<arr.size();i++){
            if(i%2==0){
                sumE+=arr.get(i);
            }
            else{
                sumO+=arr.get(i);
            }
        }
        System.out.println(sumE);
        System.out.println(sumO);        
    }
}
