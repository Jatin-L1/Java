package Queue;

public class reverseQueue {
    static void reverseQueue(QueueArray q){
        if(q.isEmpty()){
            return;
        }
        int front = q.dequeue();
        reverseQueue(q);
        q.enqueue(front);
    
    }
}
