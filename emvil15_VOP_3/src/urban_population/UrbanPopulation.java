package urban_population;

/**
 * Udleveret kodeskelet til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class UrbanPopulation implements Comparable<UrbanPopulation>{

    private String name;
    private int pop1980;
    private int pop2008;

    public UrbanPopulation(String name, int pop1980, int pop2008) {
        this.name = name;
        this.pop1980 = pop1980;
        this.pop2008 = pop2008;
    }
    
    
    
    private int getDiff() {
        
        return pop2008 - pop1980;
    }
    
    
    
    @Override
    public String toString() {
        
        return (name + " 1980: " + pop1980 + " 2008: " + pop2008 + " Diff: " + getDiff() + " \n");
        
    }

    
    @Override
    public int compareTo(UrbanPopulation o) {
        
        int thisDiff = this.getDiff();
        int anotherDiff = o.getDiff();

        if (thisDiff == anotherDiff) {
            return this.name.compareTo(o.name);
        } else {
            return (thisDiff < anotherDiff ? -1 : 1);
        }
        
    }


    
 }
