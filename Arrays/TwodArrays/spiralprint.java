package Arrays.TwodArrays;

public class spiralprint {
    public static void print(int[][] arr){
        int m = arr.length; int n=arr[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] arr ={{1,2,3,4},{14,15,16,5},{13,20,17,6},{12,19,18,7},{11,10,9,8}};
        int m =arr.length ,n =arr[0].length;
        print(arr);
        int minr ,maxr,minc,maxc;
        minr=0;
        maxr=m-1;
        minc=0;
        maxc=n-1;
        while (minr<=maxr && minc<=maxc) {
            
            for(int j=minc;j<=maxc;j++){
                System.out.print(arr[minr][j]+" ");
            }
            minr++;
            if(minr>maxr||minc>maxc) break;
            for(int i=minr;i<=maxr;i++){
                System.out.print(arr[i][maxc]+" ");
            }
            maxc--;
            if(minr>maxr||minc>maxc) break;
            for(int j=maxc;j>=minc;j--){
                System.out.print(arr[maxr][j]+" ");
            }
            maxr--;
            if(minr>maxr||minc>maxc) break;
            for(int i=maxr;i>=minr;i--){
                System.out.print(arr[i][minc]+" ");
            }
            minc++;
        }

    }
}

