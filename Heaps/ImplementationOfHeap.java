package Heaps;
class MinHeap{
    private int[] arr;
    private int size;
    MinHeap(int capacity) {
        arr = new int[capacity];
        size =0;
    }
    public void add(int num){
        arr[size++] =  num;
        upheapify(size-1);
    }
    public void upheapify(int idx){
        if(idx==0) return; // base caose
        int parent =(idx-1)/2;
        if(arr[idx]<arr[parent]){
            swap(idx,parent);
            upheapify(parent);
        }
    }
    public int peek() throws Exception{
        if(size==0) throw new Exception("Heap is Empty");
        return arr[0];
    }
    public  void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int size(){
        return size;
    }
    public int remove() throws Exception {
        if(size==0) throw new Exception("Heap is Empty");
        int peek = arr[0];
        swap(0,size-1);
        size--;
        downHeapify(0);
        return peek;

    }
    public void downHeapify(int i){
        if(i>=size-1) return;
        int leftchild = 2*i+1 , rightchild = 2*i+2;
        int minIdx = i;
        if( leftchild<size && arr[minIdx]>arr[leftchild]) minIdx = leftchild;
        if(rightchild<size &&  arr[minIdx]>arr[rightchild]) minIdx = rightchild;
        if(i==minIdx) return;
        swap(i,minIdx);
        downHeapify(minIdx);
    }


    
}

public class ImplementationOfHeap {
    public static void main(String[] args) throws Exception {
        MinHeap pq = new MinHeap(10);
        pq.add(10);
        pq.add(1);
        pq.add(6);
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
    }
}
