package group16.antgame.ant;

/**
 * The Colour enumerated type is used to differentiate between Red and Black ants.
 * @author Group 16
 * @version 24/03/2016
 */
public enum Colour {
    Red, Black;
    public static Colour oppositeColour(Colour c) {
        switch(c) {
            case Red: return Black;
            case Black: return Red;
        }
        return null;
    }
}
