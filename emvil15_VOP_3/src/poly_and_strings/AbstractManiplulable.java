package poly_and_strings;

/**
 * Udleveret abstrakt klasse til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public abstract class AbstractManiplulable implements StringManipulable{

    protected String originalString;

    public AbstractManiplulable(String originalString) {
        this.originalString = originalString;
    }

    @Override
    public String toString() {
        return getClass().getName() + ":\n"
                +originalString + " -> " + manip();
    }
    
    
    
    

}
