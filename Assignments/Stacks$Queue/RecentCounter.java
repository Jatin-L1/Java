package Assignments.Stacks$Queue;


import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter  {
    private static Queue<Integer> line;

    public RecentCounter() {
         line = new LinkedList<>();
    }
    
    public static int ping(int t) {
        if(line.isEmpty()){
            line.add(t);
        }
        else{
            if(line.peek()>=t-3000){
                line.add(t);
            }
            else{
                line.remove();
                line.add(t);
            }
        }
        return line.size();
    }
    public static void main(String[] args) {
        RecentCounter sb = new RecentCounter();
        sb.ping(51);
        
    }
}
