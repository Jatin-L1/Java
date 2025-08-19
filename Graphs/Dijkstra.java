import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import Assignments.Strings.concatrevrse;
import Heaps.nearySortedarray.Triplet;

public class Dijkstra {
    // public class Pair implements Comparable<Pair>{
    //     int node;
    //     double prob;
    //     Pair(int node  ,double prob){
    //         this.node = node ;
    //         this.prob = prob;
    //     }
    //     public int compareTo(Pair p){
    //         if(this.prob == p.prob) return this.node - p.node;
    //         return Double.compare(this.prob, p.prob);
    //     }
    // }
    // public class Pair implements Comparable<Pair>{
    //     int node;
    //     int time;
    //     Pair(int node  ,int time){
    //         this.node = node ;
    //         this.time = time;
    //     }
    //     public int compareTo(Pair p){
    //         if(this.time==p.time) return this.node - p.node;
    //         return this.time  - p.time;
    //     }
    // }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0  ;i<=n;i++) adj.add(new ArrayList<Pair>());

        for(int i = 0 ;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adj.get(u).add(new Pair(v, time));
        }
        int[] ans = new int [n+1];
        Arrays.fill(ans , Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(pq.size()>0){
            Pair top = pq.remove();
            int node = top.node;
            int time = top.time;
            if(top.time>ans[node]) continue;
            for(Pair p : adj.get(node)){
                int totalTime = top.time + p.time;
                if(totalTime<ans[p.node]){
                    ans[p.node] = totalTime;
                    pq.add(new Pair(p.node, totalTime));
                }
            }
        }
        int max = -1;

        for(int i =0 ; i<=n;i++){
            if(ans[i]>max){
                max = ans[i];
            }
        }

        if(max == Integer.MAX_VALUE) return -1;

        return max;
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0 ; i<n;i++) adj.add(new ArrayList<>());
        for(int i =0 ; i<edges.length;i++){
            int u = edges[i][0] , v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new Pair(v, prob)); 
            adj.get(u).add(new Pair(u, prob)); 
        }
        double[] ans = new double[n];
        ans[start] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(pq.size()>0){
            Pair top = pq.remove();
            if(top.prob>ans[top.node]) continue;
            for(Pair p : adj.get(top.node)){
                double totalProb = top.prob*p.prob;
                if(totalProb< ans[p.node]){
                    ans[p.node] = totalProb;
                    pq.add(new Pair(p.node, totalProb));


                }

            }
        }
        return ans[end];

    }

    public int minimumEffortPath(int[][] arr) {
        int m = arr.length , n = arr[0].length;
        int[][] ans = new int[m][n];
        for(int i =0 ;i<m;i++){
            for(int j = 0 ; j<n;j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0, 0));
        while(pq.size()>0){
            Triplet top =  pq.remove();
            int row = top.row , col = top.col , effort = top.effort;
            if(row==m-1 && col==n-1) break;
            //going up row-1
            if(row>0){
                int e = Math.abs(arr[row][col]  -arr[row-1][col]);
                e = Math.max(e ,effort);
                if(e<ans[row-1][col]){
                    ans[row-1][col]  =e;
                    pq.add(new Triplet(row-1, col, e));
                }

            }
            // going left col-1
            if(col>0){
                int e = Math.abs(arr[row][col]  -arr[row][col-1]);
                e = Math.max(e ,effort);
                if(e<ans[row][col-1]){
                    ans[row][col-1]  =e;
                    pq.add(new Triplet(row, col-1, e));
                }

            }
            // going down row+1
            if(row<m-1){
                int e = Math.abs(arr[row][col]  -arr[row+1][col]);
                e = Math.max(e ,effort);
                if(e<ans[row+1][col]){
                    ans[row+1][col]  =e;
                    pq.add(new Triplet(row+1, col, e));
                }

            }
            // going down row+1
            if(col<n-1){
                int e = Math.abs(arr[row][col]  -arr[row][col+1]);
                e = Math.max(e ,effort);
                if(e<ans[row][col+1]){
                    ans[row][col+1]  =e;
                    pq.add(new Triplet(row, col+1, e));
                }

            }
        }
        return ans[m-1][n-1];
        
    }
    public class Triplet implements Comparable<Triplet>{
        int node;
        int cost;
        int stops;
        Triplet(int node , int cost , int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
        public int compareTo(Triplet t){
            if(this.cost==t.cost) return Integer.compare(this.node, t.node);
            return Integer.compare(this.cost, t.cost);

        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0 ;i<n;i++) adj.add(new ArrayList<>());
        for(int i =0 ;i<flights.length;i++){
            int from = flights[i][0] , to = flights[i][1] , price = flights[i][2];
            adj.get(from).add(new Pair(to, price));
        }
        int[] ans = new int[n];
        Arrays.fill(ans , Integer.MAX_VALUE);
        ans[src] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(src, 0, 0));
        while(pq.size()>0){
            Triplet top = pq.remove();
            int node = top.node , cost = top.cost  , stops = top.stops;
            if(node==dst) return cost;
            if(stops==k+1) continue;
            for(Pair p : adj.get(node)){
                int totalCost = cost + p.cost;
                if(totalCost<ans[p.node]){
                    ans[p.node] =totalCost;
                    pq.add(new Triplet(p.node, totalCost, stops+1));
                }
            }
        }
        return ans[dst];

        
    }
    public class Pair{
        int node;
        int cost;
        Pair(int node  ,int cost){
            this.node = node ;
            this.cost = cost;
        }
    }
    public class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int effort;
        public Triplet(int row, int col , int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        public int compareTo(Triplet t){
            if(this.effort == t.effort) return this.row - t.row;
            return this.effort - t.effort;
        }

        
    }
    
}
