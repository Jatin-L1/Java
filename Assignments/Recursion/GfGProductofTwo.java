package Assignments.Recursion;

public class GfGProductofTwo {

    public static int product(int x,int y,int count){
        if(x<y){
            int temp = x;
            x=y;
            y=temp;
            return product(x, y, count);
        }
        if(count==y){
            return x;
        }
        return x + product(x, y, count+1);
    }
    

    public static void main(String[] args) {
        int y =5;
        int x = 4;
        System.err.println(product(x , y,1));
    }
    
}
