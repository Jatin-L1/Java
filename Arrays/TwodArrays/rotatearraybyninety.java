package Arrays.TwodArrays;
public class rotatearraybyninety {
    public static void main(String[] args) {
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9}};
        int m = arr.length;
        for(int i = 0;i<m;i++){
            for(int j=0;j<i;j++){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
    
            }
        }
        //rotate -> reverse each row
        for(int i=0;i<m;i++){
            int a=0,b=m-1;
            while(a<b){
                //swaping arr[i][a] and arr[i][b]
                int temp = arr[i][a];
                arr[i][a]=arr[i][b];
                arr[i][b]=temp;
                a++;
                b--;

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
        
    }
}   