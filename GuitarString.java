/******************************************************************************
 *  CHRIS DEBETTA
 *
 ******************************************************************************/

public class GuitarString {
    // YOUR INSTANCE VARIABLES HERE
	private RingBuffer rb;
	private double frequency;
    private double N;
    private int SAMPLING_RATE = 44100;
    private int counter;
	
    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        // YOUR CODE HERE
    	 N = SAMPLING_RATE / frequency;
         int intN = (int) (Math.ceil(N));
         rb = new RingBuffer(intN);
         for (int i = 0; i < N; i++) {
             rb.enqueue(0);
         }
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        // YOUR CODE HERE
    	int length = init.length;
        rb = new RingBuffer(length);
        for (int j = 0; j < length; j++) {
            rb.enqueue(init[j]);
        }       
    }

    // returns the number of samples in the ring buffer
    public int length() {
        // YOUR CODE HERE
    	return rb.size();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        // YOUR CODE HERE
    	 for (int k = 0; k < N; k++) {
             rb.dequeue();	
             rb.enqueue(Math.random() - 0.5);     
         }      
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        // YOUR CODE HERE
    	 double firstValue = rb.peek();
         rb.dequeue();
         double secondValue = rb.peek();
         double calculation = 0.994 * (0.5 * (firstValue + secondValue));
         rb.enqueue(calculation);
         counter++;
    }

    // returns the current sample
    public double sample() {
        // YOUR CODE HERE
    	return rb.peek();
    }


    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        // YOUR CODE HERE
    }

}
