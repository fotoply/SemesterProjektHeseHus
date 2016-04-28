package poly_and_strings;

import java.util.Arrays;

/**
 * Udleveret test klasse til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class StringManipTester {

    /**
     * Denne main()-metode kan benyttes til test af opgave 2
     */
    public static void main(String[] args) {
        StringManipulable manip;
        String input = "Test AF PolyMORPHISM!";
        
        // Fjern udkommenteringerne efterhånden som klasserne implementeres
        manip = new ToLowerManip(input);
        System.out.println(manip);
      
        manip = new ToUpperManip(input);
        System.out.println(manip);
       
        manip = new FlipUpperLowerManip(input);
        System.out.println(manip);
       
    }
    
}
