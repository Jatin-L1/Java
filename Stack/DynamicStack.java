package Stack;

import Stack.ImplementationUsingArray.ST;

public class DynamicStack extends ST {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if(this.isFull()){
            //double the arrray of size
            int[] temp = new int[data.length*2];

            // copy all the previous items in the new data
            for(int i =0;i<data.length;i++){
                temp[i] = data[i];
            }
            data = temp; // now data is pointing to the temp
        }
        //at this point we know the array is not full
        return super.push(item);

    }
    
}
