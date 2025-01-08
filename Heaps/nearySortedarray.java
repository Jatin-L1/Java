package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

import OOPS.Lec_Three.Polymorphism.triangle;

public class nearySortedarray {
    public class Triplet{
        int d;
        int x;
        int y;
        public Triplet(int d2, int x2, int y2) {
            this.d = d;
            this.x = x;
            this.y = y;
                }
            }
            public static void main(String[] args) {
                int[] arr = {6,5,3,2,8,10,9};
                int k =3;
                ArrayList<Integer> ans = new ArrayList<>();
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for(int ele  :arr){
                    pq.add(ele);
                    if(pq.size()>k) ans.add(pq.remove());
                }
                while(pq.size()>0){
                    ans.add(pq.remove());
                }
                System.out.println(ans);
            }
            public int[][] kClosest(int[][] points, int k) {
                // use have created max heap
                PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
               
                for(int i =0;i<points.length;i++){
                    int x = points[i][0] , y = points[i][1];
                    int d = x*x+y*y;
                    pq.add(new Triplet(d,x,y));
                 if(pq.size()>k) pq.remove();
        }
        int[][] ans = new int[k][2];
        for(int i =0;i<k;i++) {
            Triplet t = pq.remove();
            ans[i][0] = t.x;
            ans[i][1] = t.y;
        }
        return ans;
    }
    
}
