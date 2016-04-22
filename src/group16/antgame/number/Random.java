package group16.antgame.number;

import java.util.ArrayList;

/**
 * The Random class is used for generating random numbers for the Flip operation.
 * @author Group 16
 * @version 24/03/2016
 */
public class Random {
    
    private ArrayList<Long> s;
    private ArrayList<Long> x;
    private int i = 0;
    
    /**
     * Create a new Random number generator.
     */
    public Random(int initialSeed) {
        s = new ArrayList<>();
        x = new ArrayList<>();
        s.add((long) initialSeed);
        fillS(4);
    }
    
    private void fillS(int i) {
        for(int j = s.size(); j <= i; j++) {
            s.add((long)((long) s.get(j-1))*((long)22695477)+1);
        }
    }
    
    private void fillX(int i) {
        for(int j = x.size(); j <= i; j++) {
            x.add((long)(s.get(j+4)/((long)65536))%((long)16384));
        }
    }
    
    /**
     * Generate a new random integer between 0 (inclusive) and n (exclusive).
     * @param n The upper bound of the random number to be generated.
     * @return A random number between 0 (inclusive) and n (exclusive).
     */
    public long generateInt(int n) {
        fillS(i+4);
        fillX(i);
        return (long) x.get(i++);
    }

    public static void main(String[] args) {
        Random r = new Random(12345);
        System.out.println(r.s);
        for(int j = 0; j <= 100; j++) {
            System.out.println(""+r.generateInt(16383));
        }
    }
}
