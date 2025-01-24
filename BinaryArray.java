import java.util.HashMap;
import java.util.Map;

public class BinaryArray {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        int n = arr.length;
        int m = arr[0].length;

     
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

     
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    arr[i][j] = 1;
                }
            }
        }

    
        print(arr);
    }

    public static void print(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int maxSatisfied(int[] arr, int[] grumpy, int k) {
        int n = arr.length, i=0,j=k-1,unsatisfied = 0;
        int a = i, b =j , maxUnsatisfied = 0;
        for(int x =i;x<=j;x++){
            if(grumpy[x]==1) unsatisfied +=arr[x];
        }
        while (j<n) {
            if (maxUnsatisfied<unsatisfied) {
                maxUnsatisfied = unsatisfied;
                a=i;b=j;
            }
            i++;j++;
            if(j<n && grumpy[j]==1) unsatisfied +=arr[j];
            if(grumpy[i-1]==1) unsatisfied -=arr[i-1];
        }
        for(int x = a; x<=b;x++){
            grumpy[x]=0;
        }
        int statisfied = 0;
        for(int x =0;x<n;x++){
            if(grumpy[x]==0) statisfied +=arr[i];
        }
        return statisfied;
    }
    public int totalFruit(int[] arr) {
     int n = arr.length,i=0,j=0,maxLen =0; 
     Map<Integer,Integer> map = new HashMap<>();
     while(j<n){
        if(map.containsKey(arr[j])){
            map.put(arr[j],map.get(arr[j])+1);
        }
        else map.put(arr[j],1);

        while (map.size()>2) {
           int freq =map.get(arr[i]);
            if(freq==1) map.remove(arr[i]);
            else map.put(arr[i], freq-1)  ;
            i++;
        }
        int len = j-i+1;
        maxLen = Math.max(maxLen,len);
        j++;
     }  
     return maxLen;
    }
}
