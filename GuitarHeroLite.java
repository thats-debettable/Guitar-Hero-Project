import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*****************************************************************************
 * Sean and Chris
 *
 ****************************************************************************/

public class GuitarHeroLite {
	
	static ArrayList<fallingLetters> notes;
	static noteCircle nc;
	static Map<String, Double> loc;
	static int count = 0;

    public static void main(String[] args) throws FileNotFoundException {

        // Create two guitar strings, for concert A and C
    	loc = new HashMap<>();
    	loc.put("C", .125);
    	loc.put("C#", .1875);
    	loc.put("D", .25);
    	loc.put("Ef", .3125);
    	loc.put("E", .375);
    	loc.put("F", .5);
    	loc.put("F#", .5625);
    	loc.put("G", .625);
    	loc.put("Af", .6875);
    	loc.put("A", .75);
    	loc.put("Bf", .8125);
    	loc.put("B", .875);
    	loc.put("C", 1.0);
    	
    	notes = new ArrayList<>();
    	Scanner file = new Scanner(new File("swth.in"));
    	while(file.hasNext())
    	{
    		String temp = file.nextLine();
    		notes.add(new fallingLetters(temp, loc.get(temp)));
    	}
    	
    	for(int x = 1; x < notes.size(); x++)
    	{
    		String temp = notes.get(x).getNote();
    		if(temp.equals("C"))
    			notes.get(x).setNote("A");
    		if(temp.equals("C#"))
    			notes.get(x).setNote("W");
    		if(temp.equals("D"))
    			notes.get(x).setNote("S");
    		if(temp.equals("Ef"))
    			notes.get(x).setNote("E");
    		if(temp.equals("E"))
    			notes.get(x).setNote("D");
    		if(temp.equals("F"))
    			notes.get(x).setNote("F");
    		if(temp.equals("F#"))
    			notes.get(x).setNote("T");
    		if(temp.equals("G"))
    			notes.get(x).setNote("G");
    		if(temp.equals("Af"))
    			notes.get(x).setNote("Y");
    		if(temp.equals("A"))
    			notes.get(x).setNote("H");
    		if(temp.equals("Bf"))
    			notes.get(x).setNote("U");
    		if(temp.equals("B"))
    			notes.get(x).setNote("J");
    		if(temp.equals("CUP"))
    			notes.get(x).setNote("K");
    	}
    	
    	nc = new noteCircle(62);
    	for(fallingLetters fL : notes)
    	{
    		nc.enqueue(fL);
    	}
    	
    	double CONCERT_C = 261.63;
    	double CONCERT_CS = 277.18;
    	double CONCERT_D = 293.66;
    	double CONCERT_EF = 311.13;
    	double CONCERT_E = 329.63;
    	double CONCERT_F = 349.23;
    	double CONCERT_FS = 369.99;
    	double CONCERT_G = 392.00;
    	double CONCERT_AF = 415.30;
        double CONCERT_A = 440.0;
        double CONCERT_BF = 466.16;
        double CONCERT_B = 493.88;
        double CONCERT_C_UP = 523.25;
        
        
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringAF = new GuitarString(CONCERT_AF);
        GuitarString stringB = new GuitarString(CONCERT_B);
        GuitarString stringBF = new GuitarString(CONCERT_BF);
        GuitarString stringC = new GuitarString(CONCERT_C);
        GuitarString stringCS = new GuitarString(CONCERT_CS);
        GuitarString stringC_UP = new GuitarString(CONCERT_C_UP);
        GuitarString stringD = new GuitarString(CONCERT_D);
        GuitarString stringEF = new GuitarString(CONCERT_EF);
        GuitarString stringE = new GuitarString(CONCERT_E);
        GuitarString stringF = new GuitarString(CONCERT_F);
        GuitarString stringFS = new GuitarString(CONCERT_FS);
        GuitarString stringG = new GuitarString(CONCERT_G);

        final double TEXT_POS_X = .5;
        final double TEXT_POS_Y = .5;
        StdDraw.text(.5, .5, "Press enter to start!");
        /*
        while(true)
        {
        	if(StdDraw.hasNextKeyTyped()) 
        	{
        		int key = StdDraw.nextKeyTyped();
        		if(key == 13)
        		{
        			
        		}
        	}
        }
        */
        stairWayToHeaven();
        play(stringA, stringAF, stringB, stringBF, stringC, stringCS, stringD, stringEF, stringE, stringF, stringFS, stringG, stringC_UP);
    }
    
    private static void play(GuitarString stringA, GuitarString stringAF, GuitarString stringB, GuitarString stringBF, GuitarString stringC, GuitarString stringCS, GuitarString stringD, GuitarString stringEF, GuitarString stringE, GuitarString stringF, GuitarString stringFS, GuitarString stringG, GuitarString stringC_UP) throws FileNotFoundException {        // the main input loop
        while (true) {
            
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                if (key == 'a') 
                    stringC.pluck();
                else if (key == 'w')
                	stringCS.pluck();
                else if (key == 's')
                	stringD.pluck();
                else if (key == 'e')
                	stringEF.pluck();
                else if (key == 'd') 
                    stringE.pluck();
                else if (key == 'f') 
                    stringF.pluck();
                else if (key == 't')
                	stringFS.pluck();
                else if (key == 'g')
                	stringG.pluck();
                else if (key == 'y')
                	stringAF.pluck();
                else if (key == 'h') 
                    stringA.pluck();
                else if (key == 'u')
                	stringBF.pluck();
                else if (key == 'j') 
                    stringB.pluck();
                else if (key == 'k') 
                    stringC_UP.pluck();
                stairWayToHeaven();
            }

            // compute the superposition of the samples
            double sample = stringAF.sample() + stringA.sample() + stringBF.sample() + stringB.sample() + stringC.sample() + stringCS.sample() + stringD.sample() + stringEF.sample() + stringE.sample() + stringF.sample() + stringFS.sample() + stringG.sample() + stringC_UP.sample();

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            stringAF.tic();
            stringA.tic();
            stringBF.tic();
            stringB.tic();
            stringC.tic();
            stringCS.tic();
            stringD.tic();
            stringEF.tic();
            stringE.tic();
            stringF.tic();
            stringFS.tic();
            stringG.tic();
            stringC_UP.tic();
        }
        
    }
    
    private static void stairWayToHeaven()
    {
    	if(count == notes.size())
    	{
    		count = 0;
    	}
    	
    	StdDraw.clear();
    	StdDraw.text(.5, .5, notes.get(count).getNote());
    	count++;
    }

}
