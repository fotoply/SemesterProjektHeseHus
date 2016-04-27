package urban_population;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Udleveret kodeskelet til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class UrbanPopulationStatistics {

    private Set<UrbanPopulation> popSet;
    private File file;

    public UrbanPopulationStatistics(String fileName) {
        // Initialisering af variable

        popSet = new TreeSet();
        file = new File(fileName);
        
        readFile();
    }

    private void readFile() {
        // Til indlæsning af data fra file,
        // dannelse af objekter af klassen UrbanPopulation
        // og indsættelse af disse i popSet
    
        if(popSet.isEmpty()) {
        Scanner in = null;
        
        try {
            in = new Scanner(file);
            
            while (in.hasNextLine()) {
                
                String line = in.nextLine();
                
                String[] parts = line.split("/");
                
                String name = parts[0];
                
                int pop1980 = Integer.parseInt(parts[1]);
                
                int pop2008 = Integer.parseInt(parts[4]);
                
                popSet.add(new UrbanPopulation(name, pop1980, pop2008));
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UrbanPopulationStatistics.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            in.close();
              
        }
        }
    
    }

    
// Udleveret toString() metode, som giver en "pæn" formatering.
    @Override
    public String toString() {
        String s = popSet.toString().replaceAll(", ", "");
        return "UrbanPopulationStatistics:\n" + s.substring(1, s.length() - 1) + "\n";
    }

   
    //Udleveret test-metode
    public static void main(String[] args) {
        UrbanPopulationStatistics stats = new UrbanPopulationStatistics("ByBefolkning.txt");
        System.out.println(stats);
    }

}
