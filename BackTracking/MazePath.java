package BackTracking;

public class MazePath {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 2;

        int count = maze(1,1,rows,cols);
        System.out.println(count);
    }

    private static int maze(int i, int j, int rows, int cols) {
       if(i>rows || j>cols) return 0;
       if(i==rows && j==cols) return 1;
        int downWays = maze(i+1, j, rows, cols);
        int rightWays = maze(i, j+1, rows, cols);

        return downWays+rightWays;
    }
    
}
