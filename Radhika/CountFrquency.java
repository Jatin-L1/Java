import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountFrquency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i<n;i++) ans.add(i , sc.nextInt()); // input le liay


        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i =0  ; i<n;i++) map.put(ans.get(i) , map.getOrDefault(ans.get(i), 0)+1);
        


        for(int ele : map.keySet()){
            System.out.println(ele+" "+map.get(ele));
        }
        

    }
    
}
