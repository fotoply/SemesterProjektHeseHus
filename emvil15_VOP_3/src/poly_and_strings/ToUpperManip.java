/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly_and_strings;

/**
 *
 * @author VilleV
 */
public class ToUpperManip extends AbstractManiplulable {

    public ToUpperManip(String originalString) {
        super(originalString);
    }

    
    @Override
    public String manip() {
        return originalString.toUpperCase();
    }
    
    
}
