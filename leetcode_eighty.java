import java.util.Arrays;

public class leetcode_eighty {
    public static int[] merge(int[] a ,  int m, int[] b, int n) {
        int[] c = new int[m];
        for(int i =0;i<m;i++){
            c[i]=a[i];
        }
        int i = 0, j=0 , k=0;
        while(i<j){
            if(c[i]>b[j]){
                a[k++] = b[j++];
            }
            if(c[i]<b[j]){
                a[k++] = c[i++];
            }
        }
        if(i==m){
            while (j<n) {
                a[k++] = b[j++];
            }
        }
        if(j==n){
            while(i<m){
                a[k++] = c[i++];
            }
        }
        return a;


    }
    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int count_Zero_a=0;
        int count_Zero_b=0;
        for(int i =0;i<a.length;i++){
            if ((a[i])==0) {
                count_Zero_a++;
            }
            
        }
        int m = a.length - count_Zero_a;
        // for(int i =0;i<n;i++){
        //     if ((b[i])==0) {
        //         count_Zero_b++;
        //     }

        // }
        int[] b = {2,5,6};
        m = a.length;
        int n = b.length;
        System.out.println(m);
        for(int ele : a){
            System.out.print(ele);
        }

        // merge(a , m , b ,n);
        // for(int ele : a){
        //     System.out.print(ele);
        // }
        

    }
    
}
