package Arrays.TwodArrays;

public class wavepattern {
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
        int[][] arr = {{1,8,9,13,17},{2,7,10,14,18},{3,6,11,15,19},{4,5,12,16,29}};

        print(arr);

            for(int j =0;j<arr[0].length;j++){
                if(j%2==0){
                    for(int i =0;i<arr.length;i++){
                        System.out.print(arr[i][j]+" ");
                    }
                }
                else{
                    for(int i =arr.length-1;i>0;i--){
                        System.out.print(arr[i][j]+" ");
                    }
                }

            }
    }
    
}
