package Assignments.Stacks$Queue;

import java.util.Arrays;
import java.util.Stack;

import OOPS.Lec_two.staticint;

public class FloodFill {
    public static  int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Stack<int[]> st = new Stack<>();
        int store = image[sr][sc];
        st.push(new int[]{sr , sc});
        if(sr>0){
            if(image[sr][sc]==image[sr-1][sc]){
                st.push(new int[]{sr-1,sc});
            }
            if(image[sr][sc]==image[sr+1][sc]){
                st.push(new int[]{sr+1,sc});
            }
        }
        if(sc>0){
            if(image[sr][sc]==image[sr][sc-1]){
                st.push(new int[]{sr,sc-1});
            }
            if(image[sr][sc]==image[sr][sc+1]){
                st.push(new int[]{sr,sc+1});
            }
        }
        while(!st.isEmpty()){
            int[] check = st.pop();
            int i = check[0];
            int j = check[1];
            image[i][j]=color;
            if(i>0){
                if(image[i+1][j]==store){
                    image[i+1][j] = color;
                }
                if(image[i-1][j]==store){
                    image[i-1][j] = color;
                }
            }
            if (j>0) {
                if(image[i][j+1]==store){
                    image[i][j+1] = color;
                }
                if(image[i][j-1]==store){
                    image[i][j-1] = color;
                }
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1,1} , {1,1,0}, {1,0,1}};
       System.out.println(Arrays.toString(floodFill(arr ,1,1,2 )));
    }
}
