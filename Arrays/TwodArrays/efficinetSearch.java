package TwodArrays;

public class efficinetSearch {
    

    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15} , {2,5,8,12,19} , {3,6,9,16,22} , {10,13,14,17,24} , {18,21,23,26,30}};
        int target = 100;
        int i = 0 , j = arr[0].length-1;
        
        while(i!=arr.length && j>=0){
            if(arr[i][j]>target)j--;
            if(arr[i][j]<target)i++;
            if(arr[i][j]==target){
                System.out.println("Target found");
                break;
            }
        }
    }
}
//     public static int f1(int b) {
//         if (b == 0)
//             return 0;
//         else {
//             System.out.print("a");
//             return f1(b--);  // Recursive call
//         }
//     }
//     public static void main(String[] args) {
//         int a = f1(10);
//         System.out.println(a);
//     }
// }
