public class MyStack{
	private int maxSize;
	private long[] stackArray;
	private int top;
	public MyStack(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	public void push(long j){
		stackArray[++top] = j;
	}
	public long pop(){
		return stackArray[top--];
	}
	public long peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		return top == -1;
	}
	public boolean isFull(){
		return (top == maxSize - 1);
	}
}
//Using list
public class Stack{
	Node top;
	Object pop(){
		if(top != null){
			Node item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	void push(Object item){
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	Object peek(){
		return top.data;
	}
}
// Implement a queue using list
class Queue{
	Node front, back;
	void offer(Object item){
		if(!front){
			back = new Node(item);
			front = back;
		}
		else{
			back.next = new Node(item);
			back = back.next;
		}
	}

	void poll(){
		if(front != null){
			Object tmp = front.data;
			front = front.next;
			return tmp;
		}
		return null;
	}
}


// Implement a queue using array
public class ArrayQueue{
	int[] queue = new int[n];
	int f = 0, r = 0;
	public int size(){
		return(r - f + n) % n;
	}
	public boolean isEmpty(){
		return f == r;
	}
	public Object peek(){
		if(isEmpty())
			throw new EmptyQueueException();
		return queue[f];
	}
	public Object poll(){
		if(isEmpty())
			throw new EmptyQueueException();
		Object tmp = queue[f];
		queue[f] = null;
		f = (f + 1)	% n;
		return tmp;	
	}
	public Object offer(Object e){
		if(size() == n)
			throw new FullQueueException();
		queue[r] = e;
		r = (r + 1) % n;
	}

}



/**
 * Queue with length fixed at construction. Manually memory managed to squeeze out best efficiency.
 */
public class FixedLengthQueue<T> {
 
    // Member variables
    int maxSize ;
    int size;
    T[] queue;
    int f = 0, r = 0;
   
    public FixedLengthQueue(int maxSize, /* ... */) {
        queue = new T[maxSize];
        this.maxSize = maxSize;
        size = 0;
    }
  
    /*
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        return size;
    }
  
    /*
     * Returns true if there are no elements currently in the queue.
     */
    public boolean isEmpty() {
        return size == 0;
    }
  
    /*
     * Pops the element at the front of the queue and returns it.
     *
     * @throws NoSuchElementException if the queue is currently empty.
     */
    public T remove() {
        if(isEmpty()) throw new EmptyQueueException();
        T tmp = queue[f];
        queue[f] = null;
        f = (f + 1) % maxSize;
        size--;
        return tmp;
    }
  
    /*
     * Adds an element to the end of the queue
     *
     * @throws IllegalStateException if the queue is currently full.
     */
    public void add(T e) {
        if(size == maxSize)
            throw new FullQueueException();
        queue[r] = e;
        r = (r + 1) % maxSize;
        size++;
  
    }
  
    /*
     * Returns the element at the front of the queue without removing it.
     *
     * @throws NoSuchElementException if the queue is currently empty.
     */
    public T peek() {
        if(isEmpty()) throw new EmptyQueueException();
        return queue[f];
  
    }
    
    /**
     * Takes an array and fills it with as many elements as possible (in order) from the queue, then removes them from the queue.
     * Will overwrite anything that already exists in the array. Returns the number of elements retrieved.
     */
    /*
        FYI:
    public static void System.arraycopy(Object src,
                 int srcPos,
                 Object dest,
                 int destPos,
                 int length)
    */
    public int getSeveral(T[] arr) {
        int copySize = 0;
        // f ~ r 
        if(f < r) {
            System.arraycopy(queue, f, arr, 0, Math.min(size, arr.length));
            for(int i = f; i <= r && copySize < arr.length ; i++){
                queue[i] = null;
                copySize++;
            }
            
        }
        else{
            int size1 = Math.min(queue.length - f, arr.length);
            System.arraycopy(queue, f, arr, 0, size1);
            System.arraycopy(queue, 0, arr, size1, Math.min(size - size1, arr.length - size1));
            for(int i = f; i < queue.length && copySize < arr.length; i++){
                queue[i] = null;
                copySize++;
            }
            for(int i = 0; i < r && copySize < arr.length; i++){
                queue[i] = null;
                copySize++;
            }
        }
        f = (f + copySize) % maxSize;
        return copySize;
     
    }
}
