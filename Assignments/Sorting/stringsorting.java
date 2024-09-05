package Assignments.Sorting;

public class stringsorting {
    public static void swap(char[] arr   ,int a , int b){
        char temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        char[] str = {'z' , 'a', 't'};

        for(int i =0;i<str.length-1;i++){
            for(int x =0 ;x<str.length-1-i;x++){
                if(str[x]>str[x+1]){
                    swap(str, x, x+1);
                }
            }
        }
        for(char ele : str){
            System.out.print(ele+" ");
        }
       
    }
}
