import java.util.ArrayList;
import java.util.List;

public class cutStick {
    public static List<Integer> cutSticks(List<Integer> lengths) {
      int n = lengths.size();
      ArrayList<Integer> ans = new ArrayList<>();

      int zero = 0;
      int set = 0;
      while(zero!=n){
        zero=0;
        set=0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
         if(lengths.get(i)!=0) {
           if(lengths.get(i)<min) min = lengths.get(i);
          }
        }

        for(int i = 0 ;i<n; i++){
          if(lengths.get(i)!=0){
            int num = lengths.get(i)-min;
            lengths.set(i, num);
            set++;
          }
          else{
            zero++;
          }
        }
        if(set!=0)ans.add(set);
    
      }

      return ans;
      
  }
  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(6);
    arr.add(5);
    arr.add(4);
    arr.add(4);
    arr.add(2);
    arr.add(2);
    arr.add(8);
    System.out.println(cutSticks(arr));
  }
    
}
