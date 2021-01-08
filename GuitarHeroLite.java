import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*****************************************************************************
 * Sean and Chris
 *
 ****************************************************************************/

public class GuitarHeroLite {
	
	static String[] notes;
	static int count = 0;

    public static void main(String[] args) throws FileNotFoundException {

        // Create two guitar strings, for concert A and C
    	notes = new String[62];
    	Scanner file = new Scanner(new File("swth.in"));
    	for(int x = 0; x < notes.length; x++)
    	{
    		notes[x] = file.nextLine();
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
    
    private static void stairWayToHeaven() throws FileNotFoundException
    {
    	if(count == notes.length)
    	{
    		count = 0;
    	}
    	
    	StdDraw.clear();
    	StdDraw.text(.5, .5, notes[count]);
    	count++;
    }

}
