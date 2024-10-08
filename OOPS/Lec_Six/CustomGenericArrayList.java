package OOPS.Lec_Six;

import java.util.Arrays;

// public class CustomGenericArrayList<T>
public class CustomGenericArrayList<T extends Number>  
// used if we only wants number to be inputed
{
//ism ab hum kuch bhi daal sakte hain array list main object list wagera wagera...........
    private Object[] data;
    private static int DEFAULT_SIZE  = 10;
    private int size = 0; //also working as an index value


    public CustomGenericArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(this.isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length*2];

        // copy the current items in the new array
        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    public T remove(){
        T removed = (T)(data[--size]);
        return removed;

    }
    private boolean isFull() {
        return size== data.length;   
    }
    public T get(int index){
        return (T)data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index , T value){
        data[index]  =value;
    }

    public static void main(String[] args) {
        // ArrayList list = new ArrayList<>();

        // CustomArrayList list = new CustomArrayList();
        // list.add(3);
        // list.add(5);
        // list.add(9);

        // for(int i =0;i<14;i++){
        //     list.add(2*i);
        // }
        CustomGenericArrayList<Integer> List3 = new CustomGenericArrayList<>();

        // List3.add(45);
        for(int i = 0;i<14;i++){
            List3.add(2*i);
        }

        System.out.println(List3);
    }

    @Override
    public String toString() {
        return "CustomGenericArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
    }
    
}
