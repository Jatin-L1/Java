package TwodArrays;

public class spiral {
    public static void main(String[] args) {
        int[][]arr = {{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12}};
        int n =arr.length; //no of rows
        int m = arr[0].length; //no of cols

        // System.out.println(n);
        // System.out.println(m);

        int minr =0 , minc =0 , maxc = m -1, maxr = n-1;

        while(minr<=maxr && minc<=maxc){
            for(int i = minc ; i<=maxc;i++){
                System.out.print(arr[minr][i]+" ");
            }
            minr++;
            if (minr > maxr || minc > maxc) break;
            for(int i =minr ; i<=maxr;i++){
                System.out.print(arr[i][maxc]+" ");
            }
            maxc--;
            if (minr > maxr || minc > maxc) break;
            for(int i =  maxc;i>=minc;i--){
                System.out.print(arr[maxr][i]+" ");
            }
            maxr--;
            if (minr > maxr || minc > maxc) break;
            for(int i = maxr;i>=minr;i--){
                System.out.print(arr[i][minc]+" ");
            }
            minc++;
        }


        // int minr = 0
    }
}
