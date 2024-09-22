package OOPS.Lec_Six;
import java.util.Arrays;
// import java.util.ArrayList;
public class CustomArrayList {
    // We can't  use this ArrayList if the input is string and so on.. We need to use a concept named generics maanchana input de sake isme hum.
    private int[] data;
    private static int DEFAULT_SIZE  = 10;
    private int size = 0; //also working as an index value
    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }
    public void add(int num){
        if(this.isFull()){
            resize();
        }
        data[size++] = num;
    }
    private void resize() {
        int[] temp = new int[data.length*2];
        // copy the current items in the new array
        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    public int remove(){
        int removed = data[--size];
        return removed;

    }
    private boolean isFull() {
        return size== data.length;   
    }
    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index , int value){
        data[index]  =value;
    }

    public static void main(String[] args) {
        // ArrayList list = new ArrayList<>();

        CustomArrayList list = new CustomArrayList();
        // list.add(3);
        // list.add(5);
        // list.add(9);

        for(int i =0;i<14;i++){
            list.add(2*i);
        }

        System.out.println(list);
    }

    @Override
    public String toString() {
        return "CustomArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
    }

    

    
    
}
