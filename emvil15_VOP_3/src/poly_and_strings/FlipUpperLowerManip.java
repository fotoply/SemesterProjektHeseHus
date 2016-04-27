/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly_and_strings;

import java.util.Arrays;

/**
 *
 * @author VilleV
 */
public class FlipUpperLowerManip extends AbstractManiplulable {

    public FlipUpperLowerManip(String originalString) {
        super(originalString);
    }

    
    
    @Override
    public String manip() {
        
        char[] chars = originalString.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            
            if(Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            } else if (Character.isLowerCase(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
            
            
        }
        
        return String.valueOf(chars);
    }
    
}
