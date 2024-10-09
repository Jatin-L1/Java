package Queue;

import Stack.ImplementationUsingArray;
import Stack.DynamicStack;

public class DynamicQueue  extends CircularQueue{
    public DynamicQueue(){
        super();
    }
    public DynamicQueue(int size){
        super(size);
    }
    @Override
    public boolean insert(int item) {
        if(this.isFull()){
            //double the arrray of size
            int[] temp = new int[data.length*2];

            // copy all the previous items in the new data
            for(int i =0;i<data.length;i++){
                temp[i] = data[(front+i)% data.length];
            }
            data = temp; // now data is pointing to the temp
        }
        //at this point we know the array is not full
        return super.insert(item);

    }
    
    
}
