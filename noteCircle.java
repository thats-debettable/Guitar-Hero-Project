
public class noteCircle {
	
	private fallingLetters[] nc;
	private int first;            
	private int last; 
	
	private int size;
	
	public noteCircle(int cap)
	{
		first = 0;
		last = 0;
		size = cap;
		nc = new fallingLetters[size];
	}
	
	 public int size() 
	 {
	    return size;
	 }
		  
		
	 public boolean isEmpty() 
	 {
		return (size == 0);
	 }
		  
		 
	 public boolean isFull() 
	 {
		 return (size == nc.length);
	 }
	
	 public void enqueue(fallingLetters x) {

	    if (isFull()) {
	      throw new RuntimeException("Ring buffer overflow");
	    }
	    nc[last] = x;
	    last++;
	    size++;
	    if (last >= nc.length) {
	      last = 0;
	    }
	  }
		  
	  public fallingLetters dequeue() { 
	    if (isEmpty()) {
	      throw new RuntimeException("Ring buffer underflow");
	    }
	    fallingLetters tempValue = nc[first];
	    first++;
	    if (first >= nc.length) {
	      first = 0;
	    }
	    size--;
	    return tempValue;
	  }
	  public fallingLetters peek() {
	    if (isEmpty()) {
	      throw new RuntimeException("Ring buffer underflow");
	    }
	    return nc[first];
	  }
}
